package com.erbal.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = "com.erbal.domain")
@EnableMongoRepositories(basePackages = "com.erbal.repository")
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {

    protected String getDatabaseName() {
        return null;
    }

    public Mongo mongo() throws Exception {
        return null;
    }
}