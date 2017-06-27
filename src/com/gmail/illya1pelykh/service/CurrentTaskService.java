package com.gmail.illya1pelykh.service;

import java.util.List;

import com.gmail.illya1pelykh.entity.CurrentTask;

public interface CurrentTaskService {

	void save(CurrentTask task);

	void save(String taskTitle, String taskDescription, String deadlineDate);

	CurrentTask findOne(int id);

	List<CurrentTask> findAll();

	CurrentTask findCurrentTaskWithUserById(Integer id);

}
