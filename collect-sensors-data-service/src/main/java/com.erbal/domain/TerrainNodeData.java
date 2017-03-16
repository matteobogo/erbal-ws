package com.erbal.domain;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "node_sensors_data")
public class TerrainNodeData extends BaseNodeData {

    @Field("terrain_temperature")
    private double temperature;

    @Field("terrain_humidity")
    private double humidity;

    @Field("NodeId")
    private String nodeId;

    @PersistenceConstructor
    public TerrainNodeData(
            double temperature,
            double humidity,
            String nodeId) {

        this.temperature = temperature;
        this.humidity = humidity;
        this.nodeId = nodeId;
    }
}