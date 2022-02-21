package com.Eatlow.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
	private UserAuthenticationService authentication;

	private String message = "";

	@PostMapping("/register")
	public Map<String, String> registerUser(@Valid @RequestBody User user, BindingResult result) throws UserException {
//		this.checkForErrors(result);
		Optional<User> u = userRepository.findByEmail(user.getEmail());
		if (!u.isEmpty()) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "Email already taken");
			return error;
		}
		userRepository.save(user);
		return login(user);
	}

	@PostMapping("/login")
	public Map<String, String> login(@Valid @RequestBody User user) {
		return authentication.login(user.getEmail(), user.getPassword());
	}

	@PostMapping("/isTokenValid")
	public Map<String, Object> isTokenValid(@RequestBody Map<String, String> token) {
		return authentication.isValid(token.get("token"));
	}

//	private void checkForErrors(BindingResult result) throws UserException {
//		this.message = "";
//		if (result.hasErrors()) {
//			result.getFieldErrors().forEach(e -> {
//				this.message += e.getField() + " " + e.getDefaultMessage() + "\n";
//			});
//			throw new UserException(this.message);
//		}
//	}
}
