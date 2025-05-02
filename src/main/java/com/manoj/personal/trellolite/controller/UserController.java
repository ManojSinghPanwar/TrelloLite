package com.manoj.personal.trellolite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manoj.personal.trellolite.bean.UserBean;
import com.manoj.personal.trellolite.entity.TaskEntity;
import com.manoj.personal.trellolite.entity.User;
import com.manoj.personal.trellolite.exception.UserAlreadyExistsException;
import com.manoj.personal.trellolite.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserBean request) throws UserAlreadyExistsException
	{
		userService.addNewUser(request);
		
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> fetchUsers()
	{
		List<User> data =userService.getAllUser();
		return new ResponseEntity<List<User>>(data,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id)
	{
		User data=userService.getUser(id);
		return new ResponseEntity<User>(data,HttpStatus.OK);
	}
	
	@GetMapping("author/{author}")
	public ResponseEntity<List<TaskEntity>> fetchTasks(@PathVariable String author)
	{
		List<TaskEntity> data=userService.fetchTasksByAuthor(author);
		if(data!=null)
		{
			return new ResponseEntity<List<TaskEntity>>(data,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<TaskEntity>>(data,HttpStatus.BAD_GATEWAY);
		}
		
	}
}
