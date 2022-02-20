package com.Eatlow.security.config;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Eatlow.model.User;
import com.Eatlow.services.UserAuthentication.UserAuthenticationService;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	UserAuthenticationService auth;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	protected UserDetails retrieveUser(String email, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		final String token = (String) authentication.getCredentials();
		Optional<User> u = auth.findByToken(token);
		if (u.isEmpty())
			throw new UsernameNotFoundException("Cannot find user with authentication token= " + token);
		return u.get();

	}

}
