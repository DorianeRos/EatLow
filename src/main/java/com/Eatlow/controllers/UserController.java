package com.Eatlow.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping
	public Iterable<User> getAll() {
		return this.userRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<User> getOne(@PathVariable("id") Integer pid) throws UserException {
		this.checkUserExist(pid);
		return this.userRepository.findById(pid);
	}

}
