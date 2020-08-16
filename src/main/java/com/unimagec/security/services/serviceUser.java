package com.unimagec.security.services;

import java.util.List;

import com.unimagec.models.User;



public interface serviceUser {

	User createUser(User user);

	User updateUser(User user);

	List<User> getAllUser();

	User getUserById(long userId);

	void deleteUser(long userId);
}
