package com.example.application.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="PROJECTS")
public class ProjectEntity {
	
	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int projectId;
	

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "priority")
	private String priority;

	@Column(name = "status")
	private String status;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UserEntity userObject;
	
	@JsonInclude()
	@Transient
	private int taskCount;
	
	public int getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}

	public UserEntity getUserObject() {
		return userObject;
	}

	public void setUserObject(UserEntity userObject) {
		this.userObject = userObject;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	

}
	