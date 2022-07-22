package tn.esprit.wellbeingwork.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.wellbeingwork.entity.Role;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.RoleRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final RoleRepository roleRepository;

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElse(null);
		if (user == null ) {
			log.error("user not found");
			throw new UsernameNotFoundException("user not found in the db ");
			
		}else {
			log.info("user found");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEmail(), false, false, false, false, null);

			}

	
	
	@Override
	public User saveUser(User user) {
		log.info("We are about to save a new user {} to the DB", user.getFirstName());
		return userRepository.save(user);

	}

	@Override
	public User getUser(String email) {
		log.info("fetching the  user {}", email);
		return userRepository.findByEmail(email).orElse(null);
	}

	@Override
	public List<User> getUsers() {
		log.info("fetching all users");
		return userRepository.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		log.info("We are about to save a new role {} to the DB", role.getName());

		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		User user = userRepository.findByEmail(email).orElse(null);
		Role role = roleRepository.findByName(roleName);
		log.info("We are about to add the role {} to {}", roleName, email);
		if (user != null) {
			user.getRoles().add(role);
		}
	}


}
