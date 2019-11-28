package com.example.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.Entity.ParentTaskEntity;
import com.example.application.Entity.ProjectEntity;
import com.example.application.Entity.TaskEntity;
import com.example.application.Entity.UserEntity;
import com.example.application.repository.ParentTaskRepository;
import com.example.application.repository.ProjectRepository;
import com.example.application.repository.TaskRepository;
import com.example.application.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	UserRepository userRepo ;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ParentTaskRepository parentTaskRepo;
	
	@Autowired
	TaskRepository taskRepo;

	private static  final Logger log =  LogManager.getLogger("ProjectController");
	
	@GetMapping("/users")
	public List<UserEntity> getAllUsers(){
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userRepo.findAll().forEach(userList::add);
		log.info("Getting data from DB : " + userList);
		return userList;
		
	}	
	
	@GetMapping("/users/{id}")
	public UserEntity getUsersById(@PathVariable("id") int id){
		
		UserEntity userList = userRepo.findByUserId(id);	
		log.info("Getting getUsersById from DB : " + userList);
		return userList;
		
	}
	
	
	
	@PostMapping(value="/users/add")
	public UserEntity postUser(@RequestBody UserEntity user) {
		
		UserEntity savedUser = userRepo.save(user);
		log.info("posting data into DB : " + user);
		return savedUser;
	}
	

	 
	
	@DeleteMapping("/users/delete/{id}")
	  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
	    
	    userRepo.delete(id);
	 
	    return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
	  }
	
	@GetMapping("/projects")
	public List<ProjectEntity> getAllProjects(){
		
		List<ProjectEntity> projectList = new ArrayList<ProjectEntity>();
		projectRepo.findAll().forEach(projectList::add);
		for (ProjectEntity projectEntity : projectList) {
			projectEntity.setTaskCount(taskRepo.getTotalTasksForProjectId(projectEntity.getProjectId()));
		}
		
		return projectList;	
	}
	
	@GetMapping("/projects/{id}")
	public ProjectEntity getProjectById(@PathVariable("id") int id){
		
		ProjectEntity projectDetail = projectRepo.findByProjectId(id);		
		return projectDetail;
		
	}
	
	@PostMapping(value="/projects/add")
	public ProjectEntity postProject(@RequestBody ProjectEntity project) {
		
		ProjectEntity savedProject = projectRepo.save(project);	
		log.info("posting data into DB : " + project);
		return savedProject;
	}
	
	
	
	@GetMapping("/parentTasks")
	public List<ParentTaskEntity> getAllParentTasks(){
		
		List<ParentTaskEntity> parentTaskList = new ArrayList<ParentTaskEntity>();
		parentTaskRepo.findAll().forEach(parentTaskList::add);
		log.info("Getting data from DB : " + parentTaskList);
		return parentTaskList;
		
	}
	
	@GetMapping("/parentTasks/{id}")
	public ParentTaskEntity getParentTaskById(@PathVariable("id") int id){
		
		ParentTaskEntity parentTaskDetail = parentTaskRepo.findByParentTaskId(id);		
		return parentTaskDetail;		
	}
	
	@PostMapping(value="/parentTasks/add")
	public ParentTaskEntity postParentTask(@RequestBody ParentTaskEntity parentTask) {
		
		ParentTaskEntity savedParentTask = parentTaskRepo.save(parentTask);	
		log.info("posting data into DB : " + parentTask);
		return savedParentTask;
	}
	
	@GetMapping("/tasks")
	public List<TaskEntity> getTasks(){
		
		List<TaskEntity> taskList = new ArrayList<TaskEntity>();
		taskRepo.findAll().forEach(taskList::add);
		log.info("Getting data from DB : " + taskList);
		return taskList;
		
	}
	
	@GetMapping("/tasks/{id}")
	public TaskEntity getTaskById(@PathVariable("id") int id){
		
		TaskEntity taskDetail = taskRepo.findByTaskId(id);		
		return taskDetail;		
	}
	
	@PostMapping(value="/tasks/add")
	public TaskEntity postTask(@RequestBody TaskEntity task) {
		
		TaskEntity savedTask = taskRepo.save(task);		
		log.info("posting data into DB : " + task);
		return savedTask;
	}
	
	@GetMapping("/parentTask/projectId/{projectId}")
	public List<ParentTaskEntity> getAllParentTaskbyProjectId(@PathVariable("projectId") int projectId){
		
		List<ParentTaskEntity> parentTaskList = new ArrayList<ParentTaskEntity>();
		parentTaskRepo.getAllParentTaskbyProjectId(projectId).forEach(parentTaskList::add);
		return parentTaskList;
	}
	
	@GetMapping("/task/projectId/{projectId}")
	public List<TaskEntity> getAllTaskbyProjectId(@PathVariable("projectId") int projectId){
		
		List<TaskEntity> taskList = new ArrayList<TaskEntity>();
		taskRepo.getAllTaskbyProjectId(projectId).forEach(taskList::add);
		return taskList;
	}
}
