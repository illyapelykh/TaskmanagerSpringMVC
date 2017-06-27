package com.gmail.illya1pelykh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.illya1pelykh.dao.UserDAO;
import com.gmail.illya1pelykh.entity.User;
import com.gmail.illya1pelykh.entity.UserStatus;
import com.gmail.illya1pelykh.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(String username, String password, String userEmail, String userFullName, UserStatus userStatus) {
		User user = new User(username, passwordEncoder.encode(password), userEmail, userFullName, userStatus);
		userDAO.save(user);
	}

	@Override
	public void save(User user) {
		userDAO.save(user);
	}

	@Override
	public User findOne(Integer id) {
		return userDAO.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findUserWithTasksById(Integer id) {
		return userDAO.findUserWithTasksById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDAO.findUserByUsername(username);
	}

	@Override
	public User findUserByUsername(String username) {
		return userDAO.findUserByUsername(username);
	}

}
