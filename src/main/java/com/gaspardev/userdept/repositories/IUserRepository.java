package com.gaspardev.userdept.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaspardev.userdept.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
