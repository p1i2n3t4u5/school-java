package com.school.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.data.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByLogin(String login);

	
}


