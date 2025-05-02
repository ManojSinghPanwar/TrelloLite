package com.manoj.personal.trellolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manoj.personal.trellolite.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{

}
