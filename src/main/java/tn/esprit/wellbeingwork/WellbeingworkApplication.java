package tn.esprit.wellbeingwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.wellbeingwork.entity.Role;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.service.UserService;

@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy
@EnableScheduling
public class WellbeingworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WellbeingworkApplication.class, args);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			User user = new User();
//			user.setFirstName("ibtissem");
//			user.setLastName("lengliz");
//			user.setPositionName(tn.esprit.wellbeingwork.entity.Position.SoftwareDeveloper);
//			user.setEmail("ilengliz@gmail.com");
//			user.setPassword("030897");
//			userService.addRoleToUser(user.getEmail(), "ROLE_ADMIN");
//			userService.saveUser(user);
//
//		};
//	}
	
}
