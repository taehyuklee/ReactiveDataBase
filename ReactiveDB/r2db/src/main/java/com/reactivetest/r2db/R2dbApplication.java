package com.reactivetest.r2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.blockhound.BlockHound;

@SpringBootApplication
// @EnableR2dbcRepositories(basePackages = "com.reactivetest.r2db.person.rdb")
// @EnableReactiveMongoRepositories(basePackages = "com.reactivetest.r2db.person.mongo") // 이렇게 세부적으로 구분 안해주면 ReactiveMongo 쪽에서 R2dbc 쪽도 빈에 등록해버림
public class R2dbApplication {

	public static void main(String[] args) {
		BlockHound.install();
		SpringApplication.run(R2dbApplication.class, args);
	}

}
