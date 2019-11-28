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


@Entity
@Table(name="USERS")
public class UserEntity  {
	
	public UserEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	
 
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "EMPLOYEE_ID")
	private int employeId;

	@Column(name = "status")
	private String status;
	
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
	private TaskEntity taskId;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
	private ProjectEntity projectId;*/
	
	/*public TaskEntity getTaskId() {
		return taskId;
	}

	public void setTaskId(TaskEntity taskId) {
		this.taskId = taskId;
	}

	public ProjectEntity getProjectId() {
		return projectId;
	}

	public void setProjectId(ProjectEntity projectId) {
		this.projectId = projectId;
	}
*/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmployeId() {
		return employeId;
	}

	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}

	public int getUserId() {
		return userId;
	}
	
	public UserEntity(String firsName, String lastName, int employeeId) {
		this.firstName=firsName;
		this.lastName=lastName;
		this.employeId = employeeId;
	}

}
