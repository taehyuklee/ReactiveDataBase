for reactive MongoDB & PostgreSQL <br>

# relations of Interface for Reactive Database

<p align="center">
<img src="https://user-images.githubusercontent.com/89365465/235420080-2c2c84f5-a510-460d-b289-25966557daec.png" width="49%" height="49%">
<img src="https://user-images.githubusercontent.com/89365465/235451071-9abed2c5-076d-4324-b5b7-17267bea6532.jpg" width="49%" height="49%">
        <figcaption align="center"><p align="center">JPA Interface (Blocking) & Reactive Interface (Non-blocking) </p></figcaption>
</p>


# Reactive Mongo Template

```java
@Configuration
@ConditionalOnProperty(
        value = "common.db"
        ,havingValue = "mongo"
        ,matchIfMissing = false)
@EnableReactiveMongoRepositories(basePackages = "com.reativedb.multidb.person.repository")
public class RxMongoConfig extends AbstractReactiveMongoConfiguration {

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "TestDB";
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }
}

```
<br><br>

# Reactive RDB (eg. PostgreSQL)

```java
@Configuration
@ConditionalOnProperty(
        value = "common.db"
        ,havingValue = "rdb"
        ,matchIfMissing = false)
@EnableR2dbcRepositories(basePackages = "com.reativedb.multidb.person.repository")
public class R2dbcTemplate {
    
    @Bean
    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory databaseClient) {
        return new R2dbcEntityTemplate(databaseClient);
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.builder().connectionFactory(connectionFactory).build();
    }


}
```
<br>

### Configuration for multi-database is as like below. you need to disable some autoconfig function
``` yaml
spring:
  cloud:
    gateway:
      routes:
      - id: dbScan
        uri: http://localhost:8084
        predicates:
        - Path=/r2db


  r2dbc:
    url: r2dbc:postgresql://localhost:5432/postgres
    username: postgres

 
  data:
    mongodb:
      uri: mongodb://localhost:27017/
      database: TestDB

  autoconfigure:
    exclude:
      - org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
      - org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
      - org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
      - org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
      - org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
      - org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration
      - org.springframework.boot.autoconfigure.data.r2dbc.R2dbcAutoConfiguration
      - org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration
      - org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration
      - org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration
      - org.springframework.boot.autoconfigure.data.mongo.MongoReactiveRepositoriesAutoConfiguration
```

### build Gradle - dependencies
```groovy
plugins {
	id 'java'
	id 'org.springframework.boot' version '2.7.9'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-webflux'
	implementation 'org.springframework.cloud:spring-cloud-starter-gateway'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'org.postgresql:postgresql'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'io.projectreactor:reactor-test'  
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        
        //r2dbc dependency
	implementation 'org.springframework.boot:spring-boot-starter-data-r2dbc'
	runtimeOnly 'org.postgresql:r2dbc-postgresql'
        
        //mongodb & rxMongodb dependency
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb-reactive'
	implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
        
	implementation 'io.projectreactor.tools:blockhound:1.0.7.RELEASE'


}
```
  
