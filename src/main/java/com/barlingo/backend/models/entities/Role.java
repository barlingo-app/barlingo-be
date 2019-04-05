package com.barlingo.backend.models.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	ROLE_ADMIN, ROLE_CLIENT, ROLE_ESTABLISHMENT;

	@Override
	public String getAuthority() {
		return name();
	}

}
