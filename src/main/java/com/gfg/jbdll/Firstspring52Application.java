package com.gfg.jbdll;

import com.gfg.jbdll.domain.GENRE;
import com.gfg.jbdll.domain.Movie;
import com.gfg.jbdll.domain.MyUser;
import com.gfg.jbdll.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

@SpringBootApplication
@EnableAutoConfiguration(exclude={RedisAutoConfiguration.class})
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

		String movieKey = "TopMovies";
		Movie movie = new Movie(1, "MIB", GENRE.ACTION, 5.0);
		template.opsForList().rightPush(movieKey, movie);

		Movie movie1 = new Movie(2, "MIB-2", GENRE.ACTION, 5.0);
		template.opsForList().rightPush(movieKey, movie1);

		System.out.println(template.opsForList().range(movieKey, 0, -1));


		template.opsForHash().put(movie.getTitle(), "title", movie.getTitle());
		template.opsForHash().put(movie.getTitle(), "Id", movie.getId());
		template.opsForHash().put(movie.getTitle(), "genre", movie.getGenre());



		System.out.println(template.opsForValue().get("myJavaKey"));
		userDetailService.addUser(new MyUser("john", "123", "admin", "sha256"));
		userDetailService.addUser(new MyUser("jenny","456","user", "sha256"));
	}
}























