package com.reativedb.multidb.person;

import org.springframework.data.annotation.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Document //@Entity쓰면, Reactive Repositories are not supported by JPA 뜸.
@Table("Person")
//https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/api/index.html?org/springframework/boot/autoconfigure/data/mongo/MongoReactiveRepositoriesAutoConfiguration.html
public class Person {
    @Id
    private String id;
    private String firstNm,lastNm;
}
