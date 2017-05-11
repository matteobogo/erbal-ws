//package com.erbal.config;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//
//@Configuration
//public class ObjectMapperConfig {
//
//  @Bean
//  public ObjectMapper objectMapper() {
//
//    ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
//            .featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
//            .featuresToEnable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
//                    SerializationFeature.FAIL_ON_EMPTY_BEANS,
//                    SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//            //.modules(new JavaTimeModule())
//            .build();
//
//    return objectMapper;
//  }
//}