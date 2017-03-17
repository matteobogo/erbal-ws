package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "air_nodes_data")
@Data
public class AirNodeData extends BaseNodeData {

    @Field("sensor_type")
    private int sensorType;

    @Field("air_temperature")
    private double temperature;

    @Field("air_humidity")
    private double humidity;

    @Field("node_id")
    private String nodeId;

    @PersistenceConstructor
    public AirNodeData(
            @JsonProperty("sensorType") int sensorType,
            @JsonProperty("temperature") double temperature,
            @JsonProperty("humidity") double humidity,
            @JsonProperty("nodeId") String nodeId) {

        this.sensorType = sensorType;
        this.temperature = temperature;
        this.humidity = humidity;
        this.nodeId = nodeId;
    }
}