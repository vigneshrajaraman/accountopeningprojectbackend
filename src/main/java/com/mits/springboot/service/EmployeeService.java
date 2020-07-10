package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.Employee;
import com.mits.springboot.repo.EmployeeRepo;

@Service
public class EmployeeService {
	private EmployeeRepo repo;

	@Autowired
	public EmployeeService(EmployeeRepo repo) {
		this.repo = repo;
	}

	public Employee insertOrUpdate(Employee employee) {
		return repo.save(employee);
	}

	public List<Employee> insertAll(List<Employee> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public Employee getOne(String id) {
		return repo.getOne(id);
	}

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

}
