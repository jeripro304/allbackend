package com.springboot.userdetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.userdetails.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUsername(String username); 

}
