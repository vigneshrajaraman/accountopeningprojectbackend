package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.EmployeeType;

public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, String> {

}
