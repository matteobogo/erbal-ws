package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class SoilSampleData extends SampleData {

  @Field(SensorsDataParams.SOIL_TEMPERATURE)
  private int soilTemperatureData;

  @Field(SensorsDataParams.SOIL_MOISTURE)
  private int soilMoistureData;

  @PersistenceConstructor
  public SoilSampleData(
          @JsonProperty(SensorsDataParams.SOIL_TEMPERATURE) int soilTemperatureData,
          @JsonProperty(SensorsDataParams.SOIL_MOISTURE) int soilMoistureData) {

    this.soilTemperatureData = soilTemperatureData;
    this.soilMoistureData = soilMoistureData;
  }
}