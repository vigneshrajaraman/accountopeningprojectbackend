package com.mits.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits.springboot.entity.AccountType;

public interface AccountTypeRepo extends JpaRepository<AccountType, String> {

}
