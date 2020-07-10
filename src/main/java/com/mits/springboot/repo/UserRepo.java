package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.Authority;
import com.mits.springboot.entity.Users;

public interface UserRepo extends JpaRepository<Users, java.lang.Integer> {
	Users findByUsername(String username);
	Users findByAuthorities(Authority authorities);
}
