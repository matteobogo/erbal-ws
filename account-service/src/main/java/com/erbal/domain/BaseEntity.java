package com.erbal.domain;

import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseEntity<ID extends Serializable> implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    private ID id;
    @Version
    private Long version;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModified;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;
}