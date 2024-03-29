//package com.erbal.config;
//
//import com.mongodb.Mongo;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//
//@SuppressWarnings("ALL")
//@Configuration
//public class MongoConfig {
//
//  @Bean
//  public MongoDbFactory mongoDbFactory() throws Exception {
//    return new SimpleMongoDbFactory(new Mongo(), "erbal_db");
//  }
//
//  @Bean
//  public MongoTemplate mongoTemplate() throws Exception {
//
//    //remove _class
//    MappingMongoConverter converter =
//            new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
//    converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
//
//    return mongoTemplate;
//
//  }
//}