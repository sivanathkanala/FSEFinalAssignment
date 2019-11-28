package com.example.application.Entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="parent_tasks")
public class ParentTaskEntity {

	@Id
	@Column(name = "parent_task_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int parentTaskId;
	
	
	@Column(name="parent_task_name")
	private String parentTaskName;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectEntity projectObject;


	public int getParentTaskId() {
		return parentTaskId;
	}


	public void setParentTaskId(int parentTaskId) {
		this.parentTaskId = parentTaskId;
	}


	public String getParentTaskName() {
		return parentTaskName;
	}


	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}


	public ProjectEntity getProjectObject() {
		return projectObject;
	}


	public void setProjectObject(ProjectEntity projectObject) {
		this.projectObject = projectObject;
	}
	
	
	
}
