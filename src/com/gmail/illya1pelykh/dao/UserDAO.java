package com.gmail.illya1pelykh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gmail.illya1pelykh.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	@Query("select u from User u left outer join fetch u.currentTasks where u.id=:id")
	User findUserWithTasksById(@Param("id") int id);

	User findUserByUsername(String username);

}
