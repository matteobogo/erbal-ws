package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.erbal.utils.GreenhouseManagementParams;

import javax.validation.constraints.NotNull;

@Document(collection = "nodes")
@Data
@EqualsAndHashCode(callSuper = false)
public class Node extends BaseEntity {

    @Id
    private String id;

    @Indexed
    @NotNull(message = "Node Serial ID is compulsory")
    @NotBlank(message = "Node Serial ID is compulsory")
    @Field(GreenhouseManagementParams.NODE_ID)
    private String nodeId;

    @NotNull(message = "Node Type is compulsory")
    @NotBlank(message = "Node Type is compulsory")
    @Field(GreenhouseManagementParams.NODE_TYPE)
    private String type;

    @NotNull(message = "Sector is compulsory")
    @NotBlank(message = "Sector is compulsory")
    @Field(GreenhouseManagementParams.NODE_SECTOR)
    private String sector;

    @DBRef
    private Sink sink;

    @PersistenceConstructor
    public Node(
            @JsonProperty(GreenhouseManagementParams.NODE_ID) String nodeId,
            @JsonProperty(GreenhouseManagementParams.NODE_TYPE) String type,
            @JsonProperty(GreenhouseManagementParams.NODE_SECTOR) String sector
    ) {
        this.nodeId = nodeId;
        this.type = type;
        this.sector = sector;
    }
}