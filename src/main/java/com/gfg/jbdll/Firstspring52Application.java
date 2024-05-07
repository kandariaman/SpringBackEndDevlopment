package com.gfg.jbdll;

import com.gfg.jbdll.domain.MyUser;
import com.gfg.jbdll.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

@SpringBootApplication
public class Firstspring52Application implements CommandLineRunner {

	@Autowired
	MyUserDetailService userDetailService;

	@Autowired
	AuthenticationProvider myAuthenticationManager;
	public static void main(String[] args) {

		SpringApplication.run(Firstspring52Application.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		userDetailService.addUser(new MyUser("john", "123", "admin"));
		userDetailService.addUser(new MyUser("jenny","456","user"));
	}
}























