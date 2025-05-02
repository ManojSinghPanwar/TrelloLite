package com.manoj.personal.trellolite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manoj.personal.trellolite.bean.TaskBean;
import com.manoj.personal.trellolite.entity.TaskEntity;
import com.manoj.personal.trellolite.repository.TaskRepository;


@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	
	public boolean addTask(TaskBean task)
	{
		TaskEntity taskEntity= new TaskEntity();
		taskEntity.setBody(task.getBody());
		taskEntity.setTitle(task.getTitle());
		taskEntity.setAuthor(task.getAuthor());
		
		try {
			taskRepo.save(taskEntity);
		}catch(Exception e)
		{
			System.out.println("Exception while saving in DB"+e);
			return false;
		}
		return true;
		
	}

}
