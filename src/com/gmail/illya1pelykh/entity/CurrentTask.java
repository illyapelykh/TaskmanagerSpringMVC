package com.gmail.illya1pelykh.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CurrentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String taskTitle;
	private String taskDescription;
	private String deadlineDate;

	@Builder.Default
	@Enumerated(EnumType.STRING)
	private CurrentTaskStatus taskStatus = CurrentTaskStatus.APPLIED;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

}
