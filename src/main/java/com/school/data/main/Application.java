package com.school.data.main;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.school.data.config.JpaConfiguration;
import com.school.data.entities.Role;
import com.school.data.entities.User;
import com.school.data.service.RoleService;
import com.school.data.service.UserService;

public class Application {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				JpaConfiguration.class)) {
			UserService userService = context.getBean(UserService.class);
			RoleService roleService = context.getBean(RoleService.class);

			Role role = new Role();
			role.setRoleName("admin");
			role = roleService.saveRole(role);

			Role role2 = new Role();
			role2.setRoleName("user");
			role2 = roleService.saveRole(role2);

			Role role3 = new Role();
			role3.setRoleName("superuser");
			role3 = roleService.saveRole(role3);

			User user = new User();
			user.setAcive(true);
			user.setEmail("niranjanpanigrahi2009@gmail.com");
			user.setFirstName("Niranjan");
			user.setLastName("Panigrahi");
			user.setLogin("pintu");
			user.setPassword("pintu12345");
			user.setPhone("8951560216");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			roles.add(role2);
			roles.add(role3);
			user.setRoles(roles);
			user = userService.saveUser(user);

			User user2 = new User();
			user2.setAcive(true);
			user2.setEmail("satyamishra@gmail.com");
			user2.setFirstName("Satya");
			user2.setLastName("Mishra");
			user2.setLogin("satya");
			user2.setPassword("satya12345");
			user2.setPhone("9999999999");
			Set<Role> roles2 = new HashSet<>();
			roles2.add(role);
			roles2.add(role2);
			roles2.add(role3);
			user2.setRoles(roles2);
			user2 = userService.saveUser(user2);

		}
	}

}
