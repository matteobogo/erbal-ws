package com.erbal.domain;

import com.erbal.utils.NotifierParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document(collection = "pairs")
@Data
public class Pair {

    @Id
    private String id;

    @NotNull(message = "Sink Serial ID is compulsory")
    @NotBlank(message = "Sink Serial ID is compulsory")
    @Field(value = NotifierParams.SINK_ID)
    private String sinkId;

    @NotNull(message = "Node Serial ID is compulsory")
    @NotBlank(message = "Node Serial ID is compulsory")
    @Field(value = NotifierParams.NODE_ID)
    private String nodeId;

    @NotNull(message = "Sector is compulsory")
    @NotBlank(message = "Sector is compulsory")
    @Field(value = NotifierParams.SECTOR_ID)
    private String sectorId;

    @PersistenceConstructor
    public Pair(
            @JsonProperty(NotifierParams.SINK_ID) String sinkId,
            @JsonProperty(NotifierParams.NODE_ID) String nodeId,
            @JsonProperty(NotifierParams.SECTOR_ID) String sectorId) {

        this.sinkId = sinkId;
        this.nodeId = nodeId;
        this.sectorId = sectorId;
    }
}