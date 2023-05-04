package com.reativedb.rxmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "com.reativedb.multidb.person.repository")
public class RxMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxMongodbApplication.class, args);
	}

}
