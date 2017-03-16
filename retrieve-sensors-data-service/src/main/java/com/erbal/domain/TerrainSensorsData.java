package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sectors")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TerrainSensorsData extends SensorsData {

    @Field("temperature")
    private double temperature;

    @Field("humidity")
    private double humidity;

    @PersistenceConstructor
    public TerrainSensorsData(
            String terrainSectorId,
            double temperature,
            double humidity) {

        super(terrainSectorId);

        this.temperature = temperature;
        this.humidity = humidity;
    }
}