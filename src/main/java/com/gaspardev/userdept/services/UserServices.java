package com.gaspardev.userdept.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaspardev.userdept.dtos.UserDTO;
import com.gaspardev.userdept.entities.Department;
import com.gaspardev.userdept.entities.User;
import com.gaspardev.userdept.repositories.IDepartmentRepository;
import com.gaspardev.userdept.repositories.IUserRepository;
import com.gaspardev.userdept.services.exceptions.AppError;

@Service
public class UserServices {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	@Transactional
	public UserDTO create(User user, Long departmentId) {
		Optional<User> userExists = userRepository.findByEmail(user.getEmail());
		Optional<Department> departmentExists = departmentRepository.findById(departmentId);
		
		if(user.getEmail() == null) {
			throw new AppError("invalid data!", HttpStatus.BAD_REQUEST);
		}
		
		if(!userExists.isEmpty()) {
			throw new AppError("User already exists!", HttpStatus.BAD_REQUEST);
		}
		
		user.setDepartment(departmentExists.orElseThrow(() -> new AppError("Resource not found!", HttpStatus.NOT_FOUND)));
		
		return  new UserDTO(this.userRepository.save(user));
	}
	

}
