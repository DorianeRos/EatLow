package com.Eatlow.services.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Eatlow.model.User;
import com.Eatlow.services.User.UserService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("Username is empty");
		}

		User user = userService.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not Found");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), null);

	}

}
