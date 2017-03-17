package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class AirNodeData extends BaseNodeData{

    @Field(SensorsDataParams.SENSOR_TYPE)
    private int sensorType;

    @Field(SensorsDataParams.AIR_TEMPERATURE)
    private double temperature;

    @Field(SensorsDataParams.AIR_HUMIDITY)
    private double humidity;

    @Field(SensorsDataParams.NODE_ID)
    private String nodeId;

    @PersistenceConstructor
    public AirNodeData(
            @JsonProperty(SensorsDataParams.SENSOR_TYPE) int sensorType,
            @JsonProperty(SensorsDataParams.AIR_TEMPERATURE) double temperature,
            @JsonProperty(SensorsDataParams.AIR_HUMIDITY) double humidity,
            @JsonProperty(SensorsDataParams.NODE_ID) String nodeId) {

        this.sensorType = sensorType;
        this.temperature = temperature;
        this.humidity = humidity;
        this.nodeId = nodeId;
    }
}