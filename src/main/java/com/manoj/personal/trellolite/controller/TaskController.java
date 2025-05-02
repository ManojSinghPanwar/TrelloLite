package com.manoj.personal.trellolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.personal.trellolite.bean.TaskBean;
import com.manoj.personal.trellolite.service.TaskService;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("/addTask")
	public ResponseEntity<String> addTask(@RequestBody TaskBean request)
	{
	  boolean isSuccess=taskService.addTask(request);
	  	if(isSuccess)
	  	{
	  		return new ResponseEntity<String>("success",HttpStatus.OK);
	  	}
	  	else
	  	{
	  		return new ResponseEntity<String>("Failed",HttpStatus.BAD_REQUEST);
	  	}
	}

}
