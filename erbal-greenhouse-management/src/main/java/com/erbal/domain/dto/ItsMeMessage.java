package com.erbal.domain.dto;

import com.erbal.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class ItsMeMessage {

    @NotNull(message = "Sink Serial ID is compulsory")
    @NotBlank(message = "Sink Serial ID is compulsory")
    private String sinkId;

    @NotNull(message = "Node Serial ID is compulsory")
    @NotBlank(message = "Node Serial ID is compulsory")
    private String nodeId;

    @NotNull(message = "Node Type is compulsory")
    @NotBlank(message = "Node Type is compulsory")
    private String type;

    public ItsMeMessage(
            @JsonProperty("sink_id") String sinkId,
            @JsonProperty("node_id") String nodeId,
            @JsonProperty("type_id") String type) {

        this.sinkId = sinkId;
        this.nodeId = nodeId;
        this.type = type;
    }
}