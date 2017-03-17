package com.erbal.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NodesData")
@Data
public abstract class BaseNodeData {

    @Id
    private String id;
}