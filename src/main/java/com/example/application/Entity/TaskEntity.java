package com.example.application.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TASK")
public class TaskEntity {

	@Id
	@Column(name = "TASK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int taskId;
	
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name = "START_DATE")
	private String startDate;

	@Column(name = "END_DATE")
	private String endDate;

	@Column(name = "PRIORITY")
	private String priority;

	@Column(name = "STATUS")
	private String status;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectEntity projectObject;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UserEntity userObject;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_task_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ParentTaskEntity parentTaskObject;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProjectEntity getProjectObject() {
		return projectObject;
	}

	public void setProjectObject(ProjectEntity projectObject) {
		this.projectObject = projectObject;
	}

	public UserEntity getUserObject() {
		return userObject;
	}

	public void setUserObject(UserEntity userObject) {
		this.userObject = userObject;
	}

	public ParentTaskEntity getParentTaskObject() {
		return parentTaskObject;
	}

	public void setParentTaskObject(ParentTaskEntity parentTaskObject) {
		this.parentTaskObject = parentTaskObject;
	}
	
	
}
