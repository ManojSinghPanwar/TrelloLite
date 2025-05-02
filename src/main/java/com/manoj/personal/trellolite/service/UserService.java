package com.manoj.personal.trellolite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.personal.trellolite.entity.TaskEntity;
import com.manoj.personal.trellolite.entity.User;
import com.manoj.personal.trellolite.exception.UserAlreadyExistsException;
import com.manoj.personal.trellolite.bean.UserBean;
import com.manoj.personal.trellolite.repository.TaskRepository;
import com.manoj.personal.trellolite.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	public Boolean addNewUser(UserBean user) throws UserAlreadyExistsException
	{
		Optional<User> userInfoFromDB= userRepository.existByEmail(user.getEmail());
		
		if(!userInfoFromDB.isEmpty())
		{
			throw new UserAlreadyExistsException(user.getName()+" already exits"); //already exists
		}
		
		User userEntity= new User();
		
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		try
		{
			userRepository.save(userEntity);
		}
		catch(Exception e)
		{
			System.out.println("Error occured while saving to DB"+e);
			
		}
		return true;
	}
	
	public List<User> getAllUser()
	{
		List<User> userInfoFromDB= userRepository.findAll();
		return userInfoFromDB;
	}
	
	public User getUser(int id)
	{
		Optional<User> userInfoFromDB= userRepository.findById(id);
		User data=userInfoFromDB.get();
		return data;
	}

	public List<TaskEntity> fetchTasksByAuthor(String author)
	{
		Optional<User> data=userRepository.fetchByauthor(author);
		User userData=data.get();
		List<TaskEntity> tasks=userData.getTasks();
		return tasks;
	}

}
