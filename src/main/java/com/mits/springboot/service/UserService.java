package com.mits.springboot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mits.springboot.entity.Authority;
import com.mits.springboot.entity.Users;
import com.mits.springboot.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {
	private UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Users user = userRepo.findByUsername(username);
		if(user== null) {
			throw new UsernameNotFoundException("Invalid User");
		}
		//return new User(user.getUsername(), user.getPassword(), getAuthorities(user));
	return new User(user.getUsername(),user.getPassword(), getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(Users user) {
		String[] userRoles = user.getAuthorities().stream().map((role) -> role.getRoleName()).toArray(String[]::new);
		for(String user1: userRoles)
		System.out.println("role "+ user1);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}

	public Users getByAuthority(Authority authority) {
		return userRepo.findByAuthorities(authority);
	}

	public Users insertOrUpdate(Users user) {
		return userRepo.save(user);
	}
	public Optional<Users> getOne(String id) {
		return userRepo.findById(id);
	}
}
