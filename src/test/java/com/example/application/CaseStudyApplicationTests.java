package com.example.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.application.Entity.*;
import com.example.application.controller.ProjectController;
import com.example.application.repository.ParentTaskRepository;
import com.example.application.repository.ProjectRepository;
import com.example.application.repository.TaskRepository;
import com.example.application.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CaseStudyApplicationTests {


	@Autowired
	private ProjectController projectController;
	
	@MockBean
	private TaskRepository taskRepo;
	
	@MockBean
	private UserRepository userRepo ;	
	
	@MockBean
	private ProjectRepository projectRepo;	
	
	@MockBean
	private ParentTaskRepository parentTaskRepo;
	
	ObjectMapper mapper = new ObjectMapper();  
	

	
		
	@Test
	public void testGetTasks() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<List<TaskEntity>> mapType = new TypeReference<List<TaskEntity>>() {};
		List<TaskEntity> allTasks = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("tasks.json").getFile());
		allTasks = mapper.readValue(file, mapType);	
		when(taskRepo.findAll()).thenReturn(allTasks);
		List<TaskEntity> allTasksList = projectController.getTasks();
		assertEquals(allTasks, allTasksList);		
		verify(taskRepo,times(1)).findAll();
		verifyNoMoreInteractions(taskRepo);
	}
	
	@Test
	public void testGetUsers() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<List<UserEntity>> mapType = new TypeReference<List<UserEntity>>() {};
		List<UserEntity> allusers = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("users.json").getFile());
		allusers = mapper.readValue(file, mapType);	
		when(userRepo.findAll()).thenReturn(allusers);
		List<UserEntity> usersList = projectController.getAllUsers();
		assertEquals(allusers, usersList);		
		verify(userRepo,times(1)).findAll();
		verifyNoMoreInteractions(userRepo);
	}
	
	@Test
	public void testGetProjects() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<List<ProjectEntity>> mapType = new TypeReference<List<ProjectEntity>>() {};
		List<ProjectEntity> allprojects = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("projects.json").getFile());
		allprojects = mapper.readValue(file, mapType);	
		when(projectRepo.findAll()).thenReturn(allprojects);
		List<ProjectEntity> projectList = projectController.getAllProjects();
		assertEquals(allprojects, projectList);		
		verify(projectRepo,times(1)).findAll();
		verifyNoMoreInteractions(projectRepo);
	}
	
	
	@Test
	public void testGetParentTasks() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<List<ParentTaskEntity>> mapType = new TypeReference<List<ParentTaskEntity>>() {};
		List<ParentTaskEntity> allparentTasks = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("parentTasks.json").getFile());
		allparentTasks = mapper.readValue(file, mapType);	
		when(parentTaskRepo.findAll()).thenReturn(allparentTasks);
		List<ParentTaskEntity> parentTaskList = projectController.getAllParentTasks();
		assertEquals(allparentTasks, parentTaskList);		
		verify(parentTaskRepo,times(1)).findAll();
		verifyNoMoreInteractions(parentTaskRepo);
	}
	
	@Test
	public void testGetUserById() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<UserEntity> mapType = new TypeReference<UserEntity>() {};
		UserEntity user = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("userById.json").getFile());
		user = mapper.readValue(file, mapType);	
		when(userRepo.findByUserId(2)).thenReturn(user);
		UserEntity newUser = projectController.getUsersById(2);
		assertEquals(user, newUser);		
		verify(userRepo,times(1)).findByUserId(2);
		verifyNoMoreInteractions(userRepo);
	}
	
	@Test
	public void testGetProjectById() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<ProjectEntity> mapType = new TypeReference<ProjectEntity>() {};
		ProjectEntity project = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("projectById.json").getFile());
		project = mapper.readValue(file, mapType);	
		when(projectRepo.findByProjectId(1)).thenReturn(project);
		ProjectEntity newproject = projectController.getProjectById(1);
		assertEquals(project, newproject);		
		verify(projectRepo,times(1)).findByProjectId(1);
		verifyNoMoreInteractions(projectRepo);
	}
	
	@Test
	public void testadddUser() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<UserEntity> mapType = new TypeReference<UserEntity>() {};
		UserEntity user = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("addUser.json").getFile());
		user = mapper.readValue(file, mapType);	
		when(userRepo.save(user)).thenReturn(user);
		UserEntity newUser = projectController.postUser(user);
		assertEquals(user, newUser);		
		
	}
	
	@Test
	public void testadddProject() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<ProjectEntity> mapType = new TypeReference<ProjectEntity>() {};
		ProjectEntity project = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("addProject.json").getFile());
		project = mapper.readValue(file, mapType);	
		when(projectRepo.save(project)).thenReturn(project);
		ProjectEntity newProject = projectController.postProject(project);
		assertEquals(project, newProject);		
		
	}
	
	@Test
	public void testadddParentTask() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<ParentTaskEntity> mapType = new TypeReference<ParentTaskEntity>() {};
		ParentTaskEntity parentTask= null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("addParentTask.json").getFile());
		parentTask = mapper.readValue(file, mapType);	
		when(parentTaskRepo.save(parentTask)).thenReturn(parentTask);
		ParentTaskEntity newProject = projectController.postParentTask(parentTask);
		assertEquals(parentTask, newProject);		
		
	}
	
	@Test
	public void testaddTask() throws JsonParseException, JsonMappingException, IOException {
		TypeReference<TaskEntity> mapType = new TypeReference<TaskEntity>() {};
		TaskEntity task= null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("addTask.json").getFile());
		task = mapper.readValue(file, mapType);	
		when(taskRepo.save(task)).thenReturn(task);
		TaskEntity newtask = projectController.postTask(task);
		assertEquals(task, newtask);		
		
	}
	
}
