package com.mits.springboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.mits.springboot.entity.Authority;
import com.mits.springboot.entity.AuthorityType;
import com.mits.springboot.entity.Users;
import com.mits.springboot.service.AccountTypeService;
import com.mits.springboot.service.ApplicationService;
import com.mits.springboot.service.AuthorityService;
import com.mits.springboot.service.CardTypeService;
import com.mits.springboot.service.CustomerService;
import com.mits.springboot.service.EmployeeService;
import com.mits.springboot.service.EmployeeTypeService;
import com.mits.springboot.service.UserService;

@RestController
public class DataEntryController {
	private AccountTypeService accountTypeService;
	private ApplicationService applcationService;
	private AuthorityService authorityService;
	private CardTypeService cardTypeService;
	private CustomerService customerService;
	private EmployeeService employeeService;
	private EmployeeTypeService employeeTypeService;
	private UserService userService;

	@Autowired
	public DataEntryController(AccountTypeService accountTypeService, ApplicationService applcationService,
			AuthorityService authorityService, CardTypeService cardTypeService, CustomerService customerService,
			EmployeeService employeeService, EmployeeTypeService employeeTypeService, UserService userService) {
		super();
		this.accountTypeService = accountTypeService;
		this.applcationService = applcationService;
		this.authorityService = authorityService;
		this.cardTypeService = cardTypeService;
		this.customerService = customerService;
		this.employeeService = employeeService;
		this.employeeTypeService = employeeTypeService;
		this.userService = userService;
	}

	public DataEntryController() {

	}

	@PostConstruct
	public void intialize() {
		
		BCryptPasswordEncoder bCrypt= new BCryptPasswordEncoder();
		List<Authority> sets= new ArrayList<>();
		Authority auth=new Authority(0, "ROLE_dataSource");		
		Authority authority = authorityService.insertOrUpdate(auth);
		sets.add(authority);
		Users user= new Users(0,"vignesh", bCrypt.encode("Vignesh@1234"), "vigneshrajramanusha@gmail.com", new Date(), sets);

		Users user2 = userService.insertOrUpdate(user);
		System.out.println("inserted");
		
	}

}
