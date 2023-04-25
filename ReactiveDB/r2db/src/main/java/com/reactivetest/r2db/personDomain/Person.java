package com.reactivetest.r2db.personDomain;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document //@Entity쓰면, Reactive Repositories are not supported by JPA 뜸.
//https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/api/index.html?org/springframework/boot/autoconfigure/data/mongo/MongoReactiveRepositoriesAutoConfiguration.html
public class Person {
    @Id
    private String id;
    private String firstNm,lastNm;
}
