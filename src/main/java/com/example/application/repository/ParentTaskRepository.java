package com.example.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.application.Entity.ParentTaskEntity;

public interface ParentTaskRepository extends CrudRepository<ParentTaskEntity, Integer> {
	
	ParentTaskEntity findByParentTaskId(int id);
	
	@Query("SELECT T FROM ParentTaskEntity T WHERE T.projectObject.projectId = ?1")
	public List<ParentTaskEntity> getAllParentTaskbyProjectId(int projectId);

}
