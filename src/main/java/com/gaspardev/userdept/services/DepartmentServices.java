package com.gaspardev.userdept.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaspardev.userdept.dtos.DepartmentDTO;
import com.gaspardev.userdept.entities.Department;
import com.gaspardev.userdept.repositories.IDepartmentRepository;
import com.gaspardev.userdept.services.exceptions.AppError;

@Service
public class DepartmentServices {
	
	@Autowired
	private IDepartmentRepository repository;
	
	@Transactional
	public DepartmentDTO create(Department department) {
		
		Optional<Department> departmentExists = repository.findByName(department.getName());
		
		if(!departmentExists.isEmpty()) {
			throw new AppError("Department already exists", HttpStatus.BAD_REQUEST);
		}
		
		return new DepartmentDTO(this.repository.save(department));
	}
	
	
}
