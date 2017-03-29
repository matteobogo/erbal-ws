package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Account {

    @Field(value = "firstname")
    private String firstname;
    @Field(value = "lastname")
    private String lastname;
    @Field(value = "email")
    private String email;
    @Field(value = "passwordHash")
    @JsonIgnore
    private String passwordHash;

    public Account() {}

    @PersistenceConstructor
    public Account(
            String firstname,
            String lastname,
            String email) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
}