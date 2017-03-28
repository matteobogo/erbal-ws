package com.erbal.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account extends BaseEntity<String> {

    private String firstname;

    private String lastname;

    private String email;

    private String passwordHash;
}