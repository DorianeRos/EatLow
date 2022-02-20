package com.Eatlow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eatlow.exceptions.UserException;
import com.Eatlow.model.User;
import com.Eatlow.repository.CrudUserRepo;
import com.Eatlow.services.UserAuthentication.UserAuthenticationService;

@RestController
@CrossOrigin
@RequestMapping("api/public/auth")
public class AuthController {

	@Autowired
	private CrudUserRepo userRepository;

	@Autowired
	UserAuthenticationService authentication;

	@PostMapping("/register")
	public String registerUser(@Valid @RequestBody User user, BindingResult result) throws UserException {
		userRepository.save(user);
		return login(user);
	}

	@PostMapping("/login")
	public String login(@Valid @RequestBody User user) {
		return authentication.login(user.getEmail(), user.getPassword())
				.orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	}
}
