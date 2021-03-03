package com.twitter.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(TweeterMain.class);

	public static void main(String[] args) {

		SpringApplication.run(TweeterMain.class, args);
	}

	@Bean

	public CommandLineRunner demo(UserRepository repository) {

		return (args) -> {

			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");
		};
	}

}
