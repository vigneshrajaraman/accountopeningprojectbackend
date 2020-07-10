package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.Authority;
import com.mits.springboot.entity.AuthorityType;
import com.mits.springboot.repo.AuthorityRepo;

@Service
public class AuthorityService {
	private AuthorityRepo repo;

	@Autowired
	public AuthorityService(AuthorityRepo repo) {
		this.repo = repo;
	}

	public Authority insertOrUpdate(Authority authority) {
		return repo.save(authority);
	}

	public List<Authority> insertAll(List<Authority> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public Authority getOne(int id) {
		return repo.getOne(id);
	}

	public List<Authority> getAll() {
		return repo.findAll();
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	public Authority getByRoleName(String roleName) {
		return repo.findByRoleName(roleName);
	}
}
