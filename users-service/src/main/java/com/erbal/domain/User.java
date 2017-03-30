package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    private String id;
    @Field(value = "firstname")
    private String firstname;
    @Field(value = "lastname")
    private String lastname;
    @Field(value = "email")
    private String email;
    @Field(value = "role")
    private String role;
    @Field(value = "passwordHash")
    @JsonIgnore
    private String passwordHash;

    @PersistenceConstructor
    public User(
            String firstname,
            String lastname,
            String email,
            String role) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }
}