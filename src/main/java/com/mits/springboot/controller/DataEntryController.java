package com.mits.springboot.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mits.springboot.entity.AccountType;
import com.mits.springboot.entity.Application;
import com.mits.springboot.entity.Authority;
import com.mits.springboot.entity.CardType;
import com.mits.springboot.entity.Customer;
import com.mits.springboot.entity.Employee;
import com.mits.springboot.entity.EmployeeType;
import com.mits.springboot.entity.Gender;
import com.mits.springboot.entity.Status;
import com.mits.springboot.entity.Users;
import com.mits.springboot.model.Search;
import com.mits.springboot.service.AccountTypeService;
import com.mits.springboot.service.ApplicationService;
import com.mits.springboot.service.AuthorityService;
import com.mits.springboot.service.CardTypeService;
import com.mits.springboot.service.CustomerService;
import com.mits.springboot.service.EmployeeService;
import com.mits.springboot.service.EmployeeTypeService;
import com.mits.springboot.service.UserService;

import io.jsonwebtoken.lang.Collections;

@RestController
@RequestMapping("/dataentry")
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

		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		List<Authority> sets = new ArrayList<>();
		Authority auth = new Authority("", "ROLE_dataentery");
		Authority authority = authorityService.insertOrUpdate(auth);
		sets.add(authority);
		auth = new Authority("", "ROLE_dataverifier");
		authority = authorityService.insertOrUpdate(auth);
		sets.add(authority);
		Users user = new Users("", "vignesh", bCrypt.encode("Vignesh@1234"), "vigneshrajramanusha@gmail.com",
				new Date(), sets);
		Users user2 = userService.insertOrUpdate(user);
		List<Authority> sets2 = new ArrayList<>();
		sets2.add(authorityService.getByRoleName("ROLE_dataentery"));

		user = new Users("", "dataentry", bCrypt.encode("dataentry"), "vigneshrajramanusha2@gmail.com", new Date(),
				sets2);
		userService.insertOrUpdate(user);
		sets2 = new ArrayList<>();
		sets2.add(authorityService.getByRoleName("ROLE_dataverifier"));

		user = new Users("", "verifier", bCrypt.encode("verifier"), "vigneshrajramanusha2@gmai2.com", new Date(),
				sets2);
		userService.insertOrUpdate(user);
		System.out.println("inserted");
		EmployeeType et = new EmployeeType("1", "General");
		EmployeeType insertOrUpdate = employeeTypeService.insertOrUpdate(et);

		Employee em = new Employee("1", "vignesh", "admin", insertOrUpdate, 5000);
		Employee insertOrUpdate2 = employeeService.insertOrUpdate(em);
		Customer cus = new Customer("1", "Vignesh", "r", "Rajaraman", insertOrUpdate2, Gender.MALE, 21, "dds", "Sdsdds",
				"ssddsds");
		customerService.insertOrUpdate(cus);
		AccountType accountType = new AccountType("", "Savings");
		accountTypeService.insertOrUpdate(accountType);
		CardType cardType = new CardType("", "Basic");
		cardTypeService.insertOrUpdate(cardType);
	}

	@GetMapping("/getCustomer")
	public List<Customer> getApplicationId() {
		return customerService.getAll();
	}

	@PostMapping("/get")
	public void get(@RequestBody Customer customer) {
		System.out.println(customer);
	}

	@GetMapping("/getAllEmployeeType")
	public List<EmployeeType> getAllEmployeeType() {
		return employeeTypeService.getAll();
	}

	@GetMapping("/getAllCardType")
	public List<CardType> getAllCardType() {
		return cardTypeService.getAll();
	}

	@GetMapping("/getAllAccountType")
	public List<AccountType> getAllAccountType() {
		return accountTypeService.getAll();
	}

	@PostMapping("/insertApplication")
	public Application insertApplication(@RequestBody Application application) {
		Customer customer = application.getCustomer();
		customer.setEmployee(employeeService.insertOrUpdate(customer.getEmployee()));
		application.setCustomer(customerService.insertOrUpdate(customer));
		application.setStatus(Status.SUBMIT);
		return applcationService.insertOrUpdate(application);
	}

	@GetMapping("/getAllSubmitApplication")
	public List<Application> getAllSubmitApplication() {
		Status status = Status.SUBMIT;
		List<Application> application = new ArrayList<>();
		application.addAll(applcationService.getByStatus(status));
		status = Status.RESUBMITT;
		application.addAll(applcationService.getByStatus(status));
		return application;
	}

	@GetMapping("getCountRework")
	public Integer getCountRework() {
		return applcationService.CountByStatus(Status.REWORK);
	}

	@GetMapping("getCountVerifier")
	public Integer getCountVerifier() {
		return applcationService.CountByStatus(Status.RESUBMITT) + applcationService.CountByStatus(Status.SUBMIT);
	}

	@PutMapping("/updateApplication")
	public Application updateApplication(@RequestBody com.mits.springboot.model.Application application) {
		System.out.println(application);
		com.mits.springboot.model.Employee employee = application.getCustomer().getEmployee();
		Employee employee1 = new Employee(employee.getEmployeeId(), employee.getFirstName(), employee.getDesignation(),
				employeeTypeService.getEmployeeTypeByName(employee.getEmployeeType()), employee.getSalary());
		com.mits.springboot.model.Customer customer = application.getCustomer();
		System.out.println(customer);
		Customer customer2 = new Customer(customer.getCustomerId(), customer.getFirstName(), customer.getMiddleName(),
				customer.getLastName(), employee1, customer.getGender(), customer.getAge(),
				customer.getCorrespondenceAddress(), customer.getPresentAddress(), customer.getPermanentAddress());
		Application application2 = new Application(application.getApplicationNo(), customer2,
				accountTypeService.getAccountTypeByName(application.getAccountType()),
				cardTypeService.getCardTypeByName(application.getCardType()), application.isOvereseasAccount(),
				application.getCreateUser(), application.getCreateDate(), application.getLastModifiedUser(),
				application.getLastModifiedDate(), application.getStatus());
		application2.setStatus(Status.RESUBMITT);
		customer2.setEmployee(employeeService.insertOrUpdate(employee1));
		application2.setCustomer(customerService.insertOrUpdate(customer2));
		return applcationService.insertOrUpdate(application2);
	}

	@PutMapping("/verfierStatus")
	public Application updateVerfierStatus(@RequestBody com.mits.springboot.model.Application application) {
		System.out.println(application);
		com.mits.springboot.model.Employee employee = application.getCustomer().getEmployee();
		Employee employee1 = new Employee(employee.getEmployeeId(), employee.getFirstName(), employee.getDesignation(),
				employeeTypeService.getEmployeeTypeByName(employee.getEmployeeType()), employee.getSalary());
		com.mits.springboot.model.Customer customer = application.getCustomer();
		Customer customer2 = new Customer(customer.getCustomerId(), customer.getFirstName(), customer.getMiddleName(),
				customer.getLastName(), employee1, customer.getGender(), customer.getAge(),
				customer.getCorrespondenceAddress(), customer.getPresentAddress(), customer.getPermanentAddress());
		Application application2 = new Application(application.getApplicationNo(), customer2,
				accountTypeService.getAccountTypeByName(application.getAccountType()),
				cardTypeService.getCardTypeByName(application.getCardType()), application.isOvereseasAccount(),
				application.getCreateUser(), application.getCreateDate(), application.getLastModifiedUser(),
				application.getLastModifiedDate(), application.getStatus());
		return applcationService.insertOrUpdate(application2);
		// return null;
	}

	@GetMapping("/getAllReworkData")
	public List<Application> getAlReworkData() {
		Status status = Status.REWORK;
		return applcationService.getByStatus(status);
	}
	@PatchMapping("/Search")
	public List<Application> search(@RequestBody Search search){
		String applicationNo = search.getApplicationNo();
		System.out.println(applicationNo);
		List<Application> application= new ArrayList<>();
		if(applicationNo!=null)
			if(applicationNo.trim().length()!=0)
			application.add(applcationService.getOne(applicationNo));
		Date fromDate=search.getFromCreatedDate();
		System.out.println(fromDate);
		if(fromDate!=null)
			application.addAll(applcationService.searchBygreatherThanDateApplications(fromDate));
		Date toDate=search.getToCreatedDate();
		if(toDate!=null)
			application.addAll(applcationService.searchByLessThanDate(toDate));
		System.out.println(application);
		return application;
	}
}
