for reactive MongoDB & PostgreSQL <br>

# relations of Interface for Reactive Database
![Repository상속관계](https://user-images.githubusercontent.com/89365465/235420080-2c2c84f5-a510-460d-b289-25966557daec.png)<br>

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
