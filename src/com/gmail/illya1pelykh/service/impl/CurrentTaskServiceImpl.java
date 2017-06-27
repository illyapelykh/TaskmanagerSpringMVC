package com.gmail.illya1pelykh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.illya1pelykh.dao.CurrentTaskDAO;
import com.gmail.illya1pelykh.entity.CurrentTask;
import com.gmail.illya1pelykh.service.CurrentTaskService;

@Service
@Transactional
public class CurrentTaskServiceImpl implements CurrentTaskService {

	@Autowired
	private CurrentTaskDAO currentTaskDAO;

	@Override
	public void save(CurrentTask task) {
		currentTaskDAO.save(task);
	}

	@Override
	public void save(String taskTitle, String taskDescription, String deadlineDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public CurrentTask findOne(int id) {
		return currentTaskDAO.findOne(id);

	}

	@Override
	public List<CurrentTask> findAll() {
		return currentTaskDAO.findAll();
	}

	@Override
	public CurrentTask findCurrentTaskWithUserById(Integer id) {
		return currentTaskDAO.findCurrentTaskWithUserById(id);
	}

}
