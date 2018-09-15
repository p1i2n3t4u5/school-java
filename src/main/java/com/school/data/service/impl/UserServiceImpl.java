package com.school.data.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.data.entities.Role;
import com.school.data.entities.User;
import com.school.data.repository.RoleRepository;
import com.school.data.repository.UserRepository;
import com.school.data.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findById(long id) {
		User user = userRepository.findOne(id);
		if (user != null) {
			return user;
		}
		return null;
	}

	public User findByLogin(String name) {
		return userRepository.findByLogin(name);
	}

	public User saveUser(User user) {
		Set<Role> roles = user.getRoles();
		Set<Role> newRoles = new HashSet<>();
		for (Role role : roles) {
			newRoles.add(roleRepository.findOne(role.getId()));
		}
		user.setRoles(newRoles);
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(long id) {
		userRepository.delete(id);
	}

	public boolean isUserExist(User user) {
		return findByLogin(user.getLogin()) != null;
	}

	public void deleteAllUsers() {
		userRepository.deleteAllInBatch();
	}

}
