package com.reativedb.multidb.config;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import lombok.extern.slf4j.Slf4j;
@ConditionalOnProperty(
        value = "common.db"
        ,havingValue = "mongo"
        ,matchIfMissing = false
    )
@Configuration
@Slf4j
@EnableConfigurationProperties(MongoProperties.class)
@EnableMongoRepositories(basePackages = "com.reactivetest.r2db.scores")
public class MongoConfig {

	@Autowired
	private MongoProperties properties;
	
	public MongoConfig() {

		log.info("MongoConfig() Created");
	}
	
	@Bean
	public MongoDatabaseFactory mongoDbFactory() {

		SimpleMongoClientDatabaseFactory mongo = new SimpleMongoClientDatabaseFactory(mongoClient(), properties.getDatabase());
		return mongo;

	}

	@Bean
	public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory){
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
		return mongoTemplate;
	}

	@Bean
	public MongoClient mongoClient() {
		MongoCredential credential = MongoCredential.createCredential(properties.getUsername()
																		, properties.getDatabase()
																		, properties.getPassword());

		ConnectionString conn = new ConnectionString(String.format("mongodb://%s:%s", properties.getHost(), properties.getPort()));
		// ConnectionString conn = new ConnectionString(properties.getUri());
		MongoClientSettings settings = MongoClientSettings.builder()
											.applyConnectionString(conn)
											.credential(credential)
											.applyToConnectionPoolSettings(builder ->
																builder.minSize(10)
																.maxSize(100)
																.maxWaitTime(10, TimeUnit.SECONDS).build())
											.readPreference(ReadPreference.nearest())
											.codecRegistry(MongoClientSettings.getDefaultCodecRegistry())
											.applyToSocketSettings(builder ->
																builder.connectTimeout(100, TimeUnit.MILLISECONDS)
																.readTimeout(100, TimeUnit.MILLISECONDS).build())
											.applyToClusterSettings(builder ->
																builder.serverSelectionTimeout(0, TimeUnit.MILLISECONDS).build())
											.writeConcern(WriteConcern.UNACKNOWLEDGED)
											.retryReads(false)
											.retryWrites(false)
											.build();

		MongoClient mongoClient = MongoClients.create(settings);
		return mongoClient;
	}
}
