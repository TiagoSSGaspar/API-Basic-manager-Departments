package com.gaspardev.userdept.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaspardev.userdept.entities.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findByName(String name);
}
