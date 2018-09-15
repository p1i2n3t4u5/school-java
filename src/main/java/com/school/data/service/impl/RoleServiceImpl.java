package com.school.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.data.entities.Role;
import com.school.data.repository.RoleRepository;
import com.school.data.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> findAllRoles() {
		return roleRepository.findAll();
	}

	public Role findById(long id) {
		Role user = roleRepository.findOne(id);
		if (user != null) {
			return user;
		}
		return null;
	}

	public Role findByRoleName(String name) {
		return roleRepository.findByRoleName(name);
	}

	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	public void deleteRoleById(long id) {
		roleRepository.delete(id);
	}

	public boolean isRoleExist(Role user) {
		return findByRoleName(user.getRoleName()) != null;
	}

	public void deleteAllRoles() {
		roleRepository.deleteAllInBatch();
	}


}
