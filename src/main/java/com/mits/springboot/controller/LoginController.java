package com.mits.springboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mits.springboot.config.JwtTokenUtil;
import com.mits.springboot.entity.Users;
import com.mits.springboot.model.Token;
import com.mits.springboot.service.UserService;

@RestController
@CrossOrigin	
public class LoginController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public Token login(@RequestBody Users user) {
		System.out.println("login");
		System.out.println(user.getPassword());
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		Collection<? extends GrantedAuthority> authorities = authenticate.getAuthorities();
		String generateToken = jwtTokenUtil.generateToken(userService.loadUserByUsername(user.getUsername()));
		// System.out.println(generateToken);
		Token token = new Token();
		token.setAuthority(authorities);
		token.setToken(generateToken);
		return token;
	}

	@GetMapping("/get")
	public String test() {
		return "hellp";
	}
}
