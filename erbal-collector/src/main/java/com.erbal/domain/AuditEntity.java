package com.erbal.domain;

import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class AuditEntity<ID extends Serializable> implements Serializable, Cloneable {

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
