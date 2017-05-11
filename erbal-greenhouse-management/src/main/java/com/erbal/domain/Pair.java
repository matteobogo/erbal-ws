package com.erbal.domain;

import com.erbal.utils.GreenhouseManagementParams;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document(collection = "pairs")
@Data
@EqualsAndHashCode(callSuper = false)
public class Pair extends BaseEntity {

    @Id
    @JsonIgnore
    private String id;

    @NotNull(message = "Sink Serial ID is compulsory")
    @NotBlank(message = "Sink Serial ID is compulsory")
    @Field(value = GreenhouseManagementParams.SINK_ID)
    private String sinkId;

    @NotNull(message = "Node Serial ID is compulsory")
    @NotBlank(message = "Node Serial ID is compulsory")
    @Field(value = GreenhouseManagementParams.NODE_ID)
    private String nodeId;

    @NotNull(message = "Sector is compulsory")
    @NotBlank(message = "Sector is compulsory")
    @Field(value = GreenhouseManagementParams.SECTOR_ID)
    private String sectorId;

    @PersistenceConstructor
    public Pair(
            @JsonProperty(GreenhouseManagementParams.SINK_ID) String sinkId,
            @JsonProperty(GreenhouseManagementParams.NODE_ID) String nodeId,
            @JsonProperty(GreenhouseManagementParams.SECTOR_ID) String sectorId) {

        this.sinkId = sinkId;
        this.nodeId = nodeId;
        this.sectorId = sectorId;
    }
}