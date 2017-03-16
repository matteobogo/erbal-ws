package com.erbal.domain;

import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.*;
import java.io.Serializable;

@Data
public abstract class AuditEntity<ID extends Serializable> implements Serializable, Cloneable {

    @Id
    private ID id;
    @Version
    private Long version;
    @CreatedDate
    private DateTime createdAt;
    @LastModifiedDate
    private DateTime lastModified;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;
}