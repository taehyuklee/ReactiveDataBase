package com.reactivetest.r2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
// @EnableR2dbcRepositories(basePackages = "com.reactivetest.r2db.person")
// @EnableReactiveMongoRepositories(basePackages = "com.reactivetest.r2db.person") // 이렇게 세부적으로 구분 안해주면 ReactiveMongo 쪽에서 R2dbc 쪽도 빈에 등록해버림
public class R2dbApplication {

	public static void main(String[] args) {
		BlockHound.install();
		SpringApplication.run(R2dbApplication.class, args);
	}

}
