package com.twitter.main;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.twitter.user.User;
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
			User user1 = new User("Deepak", "deepak@gmail.cp,", "Deepak");

			user1.setJoiningDate(LocalDateTime.now());

			userRepository.save(user1);

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
