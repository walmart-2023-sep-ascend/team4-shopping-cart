package com.capstone.cartApplication.configuration;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


@Configuration
@EnableMongoRepositories(basePackages = "org.spring.mongo.demo")
public class MongoConfig extends AbstractMongoClientConfiguration{

	/*
	 * private static final String MONGO_DB_URL =
	 * "mongodb+srv://admin:admin@shoppingcart.rvqwo2v.mongodb.net/?retryWrites=true&w=majority&appName=AtlasApp";
	 * private static final String MONGO_DB_NAME = "shoppingcart";
	 * 
	 * @Bean public MongoTemplate mongoTemplate() throws IOException {
	 * EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
	 * mongo.setBindIp(MONGO_DB_URL); MongoClient mongoClient = (MongoClient)
	 * mongo.getObject(); MongoTemplate mongoTemplate = new
	 * MongoTemplate(mongoClient, MONGO_DB_NAME); return mongoTemplate; }
	 */

	@Override
	protected String getDatabaseName() {
		return "shoppingcart";
	}
	
	
	 @Override
	    public MongoClient mongoClient() {
	        final ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@shoppingcart.rvqwo2v.mongodb.net/?retryWrites=true&w=majority&appName=AtlasApp");
	        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
	            .applyConnectionString(connectionString)
	            .build();
	        return MongoClients.create(mongoClientSettings);
	    }

	    @Override
	    public Collection<String> getMappingBasePackages() {
	        return Collections.singleton("org.spring.mongo.demo");
	    }
}