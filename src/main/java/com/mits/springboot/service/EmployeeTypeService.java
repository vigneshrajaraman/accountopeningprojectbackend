package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.EmployeeType;
import com.mits.springboot.repo.EmployeeTypeRepo;

@Service
public class EmployeeTypeService {
	private EmployeeTypeRepo repo;

	@Autowired
	public EmployeeTypeService(EmployeeTypeRepo repo) {
		this.repo = repo;
	}

	public EmployeeType insertOrUpdate(EmployeeType employeeType) {
		return repo.save(employeeType);
	}

	public List<EmployeeType> insertAll(List<EmployeeType> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public EmployeeType getOne(String id) {
		return repo.getOne(id);
	}

	public List<EmployeeType> getAll() {
		return repo.findAll();
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	public EmployeeType getEmployeeTypeByName(String employeeTypeName) {
		return repo.findByEmployeeTypeName(employeeTypeName);
	}

}
