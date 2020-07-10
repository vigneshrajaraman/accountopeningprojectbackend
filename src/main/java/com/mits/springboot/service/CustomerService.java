package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.Customer;
import com.mits.springboot.repo.CustomerRepo;

@Service
public class CustomerService {
	private CustomerRepo repo;

	@Autowired
	public CustomerService(CustomerRepo repo) {
		this.repo = repo;
	}

	public Customer insertOrUpdate(Customer customer) {
		return repo.save(customer);
	}

	public List<Customer> insertAll(List<Customer> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public Customer getOne(String id) {
		return repo.getOne(id);
	}

	public List<Customer> getAll() {
		return repo.findAll();
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

}
