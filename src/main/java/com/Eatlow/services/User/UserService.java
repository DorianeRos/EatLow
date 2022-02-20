package com.Eatlow.services.User;

import com.Eatlow.model.User;

public interface UserService {
	User findByEmail(String email);
}
