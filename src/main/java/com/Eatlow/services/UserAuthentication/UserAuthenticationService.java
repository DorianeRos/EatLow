package com.Eatlow.services.UserAuthentication;

import java.util.Map;
import java.util.Optional;

import com.Eatlow.model.User;

public interface UserAuthenticationService {
	/**
	 * Logs in with the given {@code email} and {@code password}
	 * 
	 * @param email
	 * @param password
	 * @return an {@link Optional} of a user when login succeeds
	 */
	Optional<String> login(String email, String password);

	/**
	 * Finds a user by its dao-key.
	 *
	 * @param token user dao key
	 * @return
	 */
	Optional<User> findByToken(String token);

	/**
	 * Logs out the given input {@code user}.
	 *
	 * @param user the user to logout
	 */
	void logout(User user);

	/**
	 * Tells if token still valid
	 * 
	 * @param token
	 * @return boolean
	 */
	Map<String, Object> isValid(String token);
}
