package com.Eatlow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Eatlow.model.User;

public interface CrudUserRepo extends CrudRepository<User, Integer> {

	@Query("SELECT user FROM User user WHERE user.email = :email")
	public Optional<User> findByEmail(String email);
}
