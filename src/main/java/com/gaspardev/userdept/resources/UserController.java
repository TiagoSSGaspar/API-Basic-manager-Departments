package com.gaspardev.userdept.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaspardev.userdept.dtos.UserDTO;
import com.gaspardev.userdept.entities.User;
import com.gaspardev.userdept.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping({"/{id}"})
	public UserDTO createUser(@RequestBody User user, @PathVariable Long id) {
		 return userServices.create(user, id);
	}

}
