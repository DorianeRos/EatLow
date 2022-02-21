package com.Eatlow.services.UserAuthentication.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eatlow.model.User;
import com.Eatlow.repository.CrudUserRepo;
import com.Eatlow.security.jwt.TokenService;
import com.Eatlow.services.UserAuthentication.UserAuthenticationService;
import com.google.common.collect.ImmutableMap;

@Service
public class TokenAuthenticationService implements UserAuthenticationService {

	@Autowired
	TokenService tokens;
	@Autowired
	CrudUserRepo users;

	@Override
	public Optional<String> login(String email, String password) {
		return users.findByEmail(email).filter(user -> Objects.equals(password, user.getPassword()))
				.map(user -> tokens.expiring(ImmutableMap.of("email", email)));
	}

	@Override
	public Optional<User> findByToken(String token) {
		String email = Optional.of(tokens.verify(token)).map(map -> map.get("email")).get();
		Optional<User> user = users.findByEmail(email);
		return user;
	}

	@Override
	public void logout(User user) {
		// TODO Auto-generated method stub

	}

}
