package com.gfg.jbdll;

import com.gfg.jbdll.domain.MyUser;
import com.gfg.jbdll.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

@SpringBootApplication
public class Firstspring52Application implements CommandLineRunner {

	@Autowired
	MyUserDetailService userDetailService;

	@Autowired
	AuthenticationProvider myAuthenticationManager;

	@Autowired
	RedisTemplate template;
	public static void main(String[] args) {

		SpringApplication.run(Firstspring52Application.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		template.opsForValue().set("myJavaKey","myJavaValue");
		userDetailService.addUser(new MyUser("john", "123", "admin", "sha256"));
		userDetailService.addUser(new MyUser("jenny","456","user", "sha256"));
	}
}























