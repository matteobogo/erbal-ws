package com.erbal.domain;

import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

public abstract class AuditEntity {

    @Id
    private String id;
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
