for reactive MongoDB & PostgreSQL <br>

# relations of Interface for Reactive Database

<p align="center">
<img src="https://user-images.githubusercontent.com/89365465/235420080-2c2c84f5-a510-460d-b289-25966557daec.png" width="49%" height="49%">
<img src="https://https://user-images.githubusercontent.com/89365465/235451014-3e5e5e27-c8d1-4154-8cb3-3a46614f7499.jpg" width="49%" height="49%">
<figcaption align="center">No Control-shear flow & Controlled Shear flow</figcaption>
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
