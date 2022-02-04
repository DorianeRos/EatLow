package com.Eatlow.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eatlow.exceptions.UserException;
import com.Eatlow.model.User;
import com.Eatlow.repository.CrudUserRepo;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private CrudUserRepo userRepository;

	private String message;

	private void checkUserExist(Integer id) throws UserException {
		if (this.userRepository.findById(id).isEmpty()) {
			throw new UserException("User with id: " + id + " doesn't not exist");
		}
	}

	private void checkForErrors(BindingResult result) throws UserException {
		this.message = "";
		if (result.hasErrors()) {
			result.getFieldErrors().forEach(e -> {
				this.message += e.getField() + " " + e.getDefaultMessage() + "\n";
			});
			throw new UserException(this.message);
		}
	}

	private void checkForPasswordValidity(String password, String passwordInDB) throws UserException {
		if (!password.equals(passwordInDB)) {
			throw new UserException("La combinaison Email/password ne correspondent pas");
		}
	}

	private void checkForLogin(User user) throws UserException {
		Boolean noEmail = user.getEmail().isEmpty() || user.getEmail().isBlank();
		Boolean noPassword = user.getPassword().isEmpty() || user.getPassword().isBlank();
		if (noEmail) {
			throw new UserException("Veuillez entrer un Email valide");
		}
		if (noPassword) {
			throw new UserException("Veuillez entrer un Password valide");
		}
	}

	@GetMapping
	public Iterable<User> getAll() {
		return this.userRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<User> getOne(@PathVariable("id") Integer pid) throws UserException {
		this.checkUserExist(pid);
		return this.userRepository.findById(pid);
	}

	@PostMapping("/register")
	public User registerUser(@Valid @RequestBody User user, BindingResult result) throws UserException {
		this.checkForErrors(result);
		this.userRepository.save(user);
		return user;
	}

	@PostMapping("/login")
	public Map<String, String> loginUser(@Valid @RequestBody User user, BindingResult result) throws UserException {
		Map<String, String> message = new HashMap<>();
		this.checkForLogin(user);
		Optional<User> userInDB = this.userRepository.findByEmail(user.getEmail());
		if (userInDB.isEmpty()) {
			message.put("Error",
					new UserException("User with email: " + user.getEmail() + " doesn't exist").getMessage());
			return message;
		}
		this.checkForPasswordValidity(user.getPassword(), userInDB.get().getPassword());
		message.put("Bravo", "Tu es connecté GG");
		return message;
	}
}
