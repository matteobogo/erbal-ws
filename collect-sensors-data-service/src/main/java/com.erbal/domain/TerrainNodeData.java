package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class TerrainNodeData extends BaseNodeData{

    @Field(SensorsDataParams.SENSOR_TYPE)
    private int sensorType;

    @Field(SensorsDataParams.TERRAIN_TEMPERATURE)
    private double temperature;

    @Field(SensorsDataParams.TERRAIN_HUMIDITY)
    private double humidity;

    @Field(SensorsDataParams.NODE_ID)
    private String nodeId;

    @PersistenceConstructor
    public TerrainNodeData(
            @JsonProperty(SensorsDataParams.SENSOR_TYPE) int sensorType,
            @JsonProperty(SensorsDataParams.TERRAIN_TEMPERATURE) double temperature,
            @JsonProperty(SensorsDataParams.TERRAIN_HUMIDITY) double humidity,
            @JsonProperty(SensorsDataParams.NODE_ID) String nodeId) {

        this.sensorType = sensorType;
        this.temperature = temperature;
        this.humidity = humidity;
        this.nodeId = nodeId;
    }
}