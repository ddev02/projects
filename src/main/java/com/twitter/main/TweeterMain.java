package com.twitter.main;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.twitter.entity.user.User;
import com.twitter.user.repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.twitter" })
@EnableJpaRepositories(basePackages = { "com.twitter" })
@EntityScan("com.twitter.*")  
public class TweeterMain {

	public static void main(String[] args) {

		SpringApplication.run(TweeterMain.class, args);
	}

	@Bean

	public CommandLineRunner demo(UserRepository repository) {

		return (args) -> {

			User user1 = new User("Deepak", "deepak@gmail.cp,", "Deepak");

			user1.setJoiningDate(LocalDateTime.now());
			
			
			User user11 = new User("Deepak", "deepak@gmail.cp,", "Deepak");

			user11.setJoiningDate(LocalDateTime.now());
			
			User user111 = new User("Deepak", "deepak@gmail.cp,", "Deepak");

			user111.setJoiningDate(LocalDateTime.now());
			
			User user1111 = new User("Deepak", "deepak@gmail.cp,", "Deepak");

			user1111.setJoiningDate(LocalDateTime.now());
			

			repository.save(user1);
			repository.save(user11);
			repository.save(user111);
			repository.save(user1111);
		};
	}

}
