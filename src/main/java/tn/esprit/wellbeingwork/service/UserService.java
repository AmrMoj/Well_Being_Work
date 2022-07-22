package tn.esprit.wellbeingwork.service;

import java.util.List;

import tn.esprit.wellbeingwork.entity.Role;
import tn.esprit.wellbeingwork.entity.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String email,String roleName);
	User getUser(String email);
	List<User> getUsers();
	
}
