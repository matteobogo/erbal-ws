package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Field(value = "firstname")
    private String firstname;
    @Field(value = "lastname")
    private String lastname;
    @Field(value = "email")
    private String email;
    @Field(value = "passwordHash")
    @JsonIgnore
    private String passwordHash;
}