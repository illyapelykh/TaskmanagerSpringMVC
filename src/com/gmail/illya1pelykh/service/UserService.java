package com.gmail.illya1pelykh.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gmail.illya1pelykh.entity.User;
import com.gmail.illya1pelykh.entity.UserStatus;

public interface UserService extends UserDetailsService {

	void save(String username, String password, String userEmail, String userFullName, UserStatus userStatus);

	void save(User user);

	User findOne(Integer id);

	List<User> findAll();

	User findUserWithTasksById(Integer id);

	User findUserByUsername(String username);

}
