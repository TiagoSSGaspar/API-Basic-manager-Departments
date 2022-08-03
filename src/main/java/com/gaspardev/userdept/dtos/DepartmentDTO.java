package com.gaspardev.userdept.dtos;

import com.gaspardev.userdept.entities.Department;

public class DepartmentDTO {
	
	private Long id;
	private String name;
	
	
	public DepartmentDTO() {}
	
	
	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Department department) {
		id = department.getId();
		name = department.getName();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
