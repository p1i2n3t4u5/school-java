package com.school.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.data.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRoleName(String role);

}
