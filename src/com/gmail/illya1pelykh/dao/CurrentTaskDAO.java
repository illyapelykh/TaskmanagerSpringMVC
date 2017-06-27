package com.gmail.illya1pelykh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gmail.illya1pelykh.entity.CurrentTask;

public interface CurrentTaskDAO extends JpaRepository<CurrentTask, Integer> {

	@Query("from CurrentTask c join fetch c.user where c.id=:id")
	CurrentTask findCurrentTaskWithUserById(@Param("id") int id);

}
