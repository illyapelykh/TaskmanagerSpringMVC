package com.gmail.illya1pelykh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.illya1pelykh.entity.CurrentTask;
import com.gmail.illya1pelykh.entity.CurrentTaskStatus;
import com.gmail.illya1pelykh.entity.User;
import com.gmail.illya1pelykh.service.CurrentTaskService;
import com.gmail.illya1pelykh.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private CurrentTaskService currentTaskService;

	@PostMapping("/userAttachTask{idThis}")
	public String userAttachTask(@PathVariable("idThis") int id, @RequestParam String taskTitle,
			@RequestParam String taskDescription, @RequestParam String deadlineDate) {

		currentTaskService.save(CurrentTask.builder().taskTitle(taskTitle).taskDescription(taskDescription)
				.deadlineDate(deadlineDate).user(userService.findOne(id)).build());

		return "redirect:/userDetails" + id;
	}

	@GetMapping("/attachTask{idThis}")
	public String attachTask(@PathVariable("idThis") int id, Model model) {

		User user = userService.findUserWithTasksById(id);
		model.addAttribute("user", user);

		return "attachTaskPage";
	}

	@PostMapping("/userAttachTaskPage{id}")
	public String userAttachTaskPage(@PathVariable int id, @RequestParam String taskTitle,
			@RequestParam String taskDescription, @RequestParam String deadlineDate) {

		currentTaskService.save(CurrentTask.builder().taskTitle(taskTitle).taskDescription(taskDescription)
				.deadlineDate(deadlineDate).user(userService.findOne(id)).build());

		return "redirect:/showAllUsers";
	}

	@PostMapping("/changeTaskStatus{id}")
	public String changeTaskStatus(@PathVariable int id, @RequestParam CurrentTaskStatus status) {

		CurrentTask task = currentTaskService.findOne(id);
		task.setTaskStatus(status);
		currentTaskService.save(task);

		return "redirect:/taskDetails" + id;
	}

}
