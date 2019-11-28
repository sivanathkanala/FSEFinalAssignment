package com.example.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.application.Entity.ProjectEntity;


@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Integer> {
	
	ProjectEntity findByProjectId(int id);

}
