package com.erbal.domain;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sectors")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class TerrainSector extends BaseEntity<String> {

    @Field("temperature")
    private double temperature;

    @Field("humidity")
    private double humidity;

    @PersistenceConstructor
    public TerrainSector(
            double temperature,
            double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
}