package com.Eatlow.services.User.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Eatlow.model.User;
import com.Eatlow.repository.CrudUserRepo;
import com.Eatlow.services.User.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CrudUserRepo userRepository;

	@Override
	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		User user = null;
		try {
			user = userRepository.findByEmail(email).get();
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

}
