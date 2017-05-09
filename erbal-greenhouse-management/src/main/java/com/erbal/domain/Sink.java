package com.erbal.domain;

import com.erbal.utils.GreenhouseManagementParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document(collection = "sinks")
@Data
@EqualsAndHashCode(callSuper = false)
public class Sink extends BaseEntity {

    @Id
    private String id;

    @Indexed
    @Field(GreenhouseManagementParams.SINK_ID)
    private String sinkId;

    @Field(GreenhouseManagementParams.SINK_GREENHOUSE_NAME)
    private String greenhouseName;

    @Field(GreenhouseManagementParams.SINK_USER_ID)
    private String userId;

    @PersistenceConstructor
    public Sink(
            @JsonProperty(GreenhouseManagementParams.SINK_ID) String sinkId,
            @JsonProperty(GreenhouseManagementParams.SINK_GREENHOUSE_NAME) String greenhouseName,
            @JsonProperty(GreenhouseManagementParams.SINK_USER_ID) String userId
    ) {
        this.sinkId = sinkId;
        this.greenhouseName = greenhouseName;
        this.userId = userId;
    }
}