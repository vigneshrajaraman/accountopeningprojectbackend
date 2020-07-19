package com.mits.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.AccountType;
import com.mits.springboot.repo.AccountTypeRepo;

@Service
public class AccountTypeService {
	private AccountTypeRepo repo;

	@Autowired
	public AccountTypeService(AccountTypeRepo repo) {
		this.repo = repo;
	}

	public AccountType insertOrUpdate(AccountType accountType) {
		return repo.save(accountType);
	}

	public List<AccountType> insertAll(List<AccountType> list) {
		return list.stream().map(this::insertOrUpdate).collect(Collectors.toList());
	}

	public AccountType getOne(String id) {
		return repo.getOne(id);
	}

	public List<AccountType> getAll() {
		return repo.findAll();
	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	public AccountType getAccountTypeByName(String accountTypeName) {
		return repo.findByAccountTypeName(accountTypeName);
	}
}
