package com.mits.springboot.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class Token {
	private String token;
	private Collection<? extends GrantedAuthority> authority;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Collection<? extends GrantedAuthority> getAuthority() {
		return authority;
	}

	public void setAuthority(Collection<? extends GrantedAuthority> authority) {
		this.authority = authority;
	}

}
