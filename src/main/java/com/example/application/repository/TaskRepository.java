package com.example.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.application.Entity.TaskEntity;

public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {

	TaskEntity findByTaskId(int id);
	
	
	@Query("SELECT T FROM TaskEntity T WHERE T.projectObject.projectId = ?1")
	public List<TaskEntity> getAllTaskbyProjectId(int projectId);
	
	@Query("SELECT count(t) FROM TaskEntity t where t.projectObject.projectId = ?1")
	public int getTotalTasksForProjectId(int projectId);
}
