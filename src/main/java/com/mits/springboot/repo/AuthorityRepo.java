package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.Authority;
import com.mits.springboot.entity.AuthorityType;

public interface AuthorityRepo extends JpaRepository<Authority, Integer> {
Authority findByRoleName(String roleName);
}
