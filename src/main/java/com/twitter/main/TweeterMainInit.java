package com.twitter.main;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.twitter.entity.user.User;
import com.twitter.user.repository.UserRepository;

@Component
public class TweeterMainInit implements ApplicationRunner {

	private static final Logger log = LoggerFactory.getLogger(TweeterMainInit.class);
	@Autowired
	private UserRepository userRepository;

	// public static void main(String[] args) {
	//
	// ProxyMessagingLayer messagingLayer = new ProxyMessagingLayer();
	// messagingLayer.addObserver(new TweetDBConnector());
	// TweeterServiceManager manager = new
	// TweeterServiceManagerImpl(messagingLayer);
	//
	// TweeterServiceController controller = new
	// TweeterServiceController(manager);
	// Tweet tweet = new TextMessage("GAHHHH", 1, "dev_id");
	// controller.tweet(tweet);
	//
	// }

	@Override
	public void run(ApplicationArguments args) throws Exception {

		long count = userRepository.count();

		if (count == 0) {


			User user1 = new User("Deepak", "deepak1@gmail.cp,", "Deepak1");

			user1.setJoiningDate(LocalDateTime.now());
			
			
			User user11 = new User("Deepak", "deepak2@gmail.cp,", "Deepak2");

			user11.setJoiningDate(LocalDateTime.now());
			
			User user111 = new User("Deepak", "deepak3@gmail.cp,", "Deepak3");

			user111.setJoiningDate(LocalDateTime.now());
			
			User user1111 = new User("Deepak", "deepak4@gmail.cp,", "Deepak4");

			user1111.setJoiningDate(LocalDateTime.now());
			

			userRepository.save(user1);
			userRepository.save(user11);
			userRepository.save(user111);
			userRepository.save(user1111);


		} else {

			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("");
		}

	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
