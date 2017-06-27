package com.gmail.illya1pelykh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gmail.illya1pelykh.entity.User;

@Component
public class UserValidator implements Validator {

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(User.class);
	}

	@Override
	public void validate(Object object, Errors error) {
		List<User> userList = userService.findAll();
		User user = (User) object;

		userList.forEach(u -> {
			if (u.getUsername().equals(user.getUsername())) {
				error.rejectValue("username", "450", "username allready exist");
			}
			if (u.getUserEmail().equals(user.getUserEmail())) {
				error.rejectValue("username", "450", "email allready exist");
			}
		});

	}

}
