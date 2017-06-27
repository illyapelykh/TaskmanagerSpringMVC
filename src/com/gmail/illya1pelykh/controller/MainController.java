package com.gmail.illya1pelykh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.illya1pelykh.entity.CurrentTask;
import com.gmail.illya1pelykh.entity.CurrentTaskStatus;
import com.gmail.illya1pelykh.entity.User;
import com.gmail.illya1pelykh.entity.UserStatus;
import com.gmail.illya1pelykh.service.CurrentTaskService;
import com.gmail.illya1pelykh.service.UserService;
import com.gmail.illya1pelykh.service.UserValidator;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private CurrentTaskService taskService;

	@Autowired
	private UserValidator userValidator;

	@InitBinder("newUser")
	public void binder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userValidator);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/createUserPage")
	public String createUserPage(Model model) {
		model.addAttribute("status", UserStatus.values());
		return "createUserPage";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute("newUser") @Validated User user, BindingResult result, Model model,
			@RequestParam String password) {
		if (result.hasErrors()) {
			model.addAttribute("status", UserStatus.values());
			model.addAttribute("error", result.getFieldError());
			return "createUserPage";
		}
		user.setPassword(passwordEncoder.encode(password));
		userService.save(user);
		return "home";
	}

	@GetMapping("/showAllUsers")
	public String showAllUsers(Model model) {
		model.addAttribute("allUsers", userService.findAll());
		return "allUsersPage";
	}

	@GetMapping("/userDetails{id}")
	public String userDetails(@PathVariable int id, Model model) {
		User user = userService.findUserWithTasksById(id);
		model.addAttribute("user", user);
		return "userPage";
	}

	@GetMapping("/taskDetails{id}")
	public String taskDetails(@PathVariable int id, Model model) {
		CurrentTask task = taskService.findCurrentTaskWithUserById(id);
		model.addAttribute("task", task);
		model.addAttribute("status", CurrentTaskStatus.values());
		return "currentTaskPage";
	}

}
