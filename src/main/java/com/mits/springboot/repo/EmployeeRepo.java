package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
