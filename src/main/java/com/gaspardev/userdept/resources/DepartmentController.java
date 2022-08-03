package com.gaspardev.userdept.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaspardev.userdept.dtos.DepartmentDTO;
import com.gaspardev.userdept.entities.Department;
import com.gaspardev.userdept.services.DepartmentServices;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentServices departmentServices;
	
	@PostMapping
	public DepartmentDTO createDepartment(@RequestBody Department department) {
		 return departmentServices.create(department);
	}

}
