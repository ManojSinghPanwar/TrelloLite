package com.manoj.personal.trellolite.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.manoj.personal.trellolite.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query("Select u from User u where u.email = :email")
	public Optional<User> existByEmail(String email);
	
	@Query("Select u from User u where u.name= :author")
	public Optional<User> fetchByauthor(String author);

}
