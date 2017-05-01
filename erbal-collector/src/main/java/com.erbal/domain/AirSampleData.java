package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class AirSampleData extends SampleData {

  @Field(SensorsDataParams.AIR_TEMPERATURE)
  private int airTemperatureData;

  @Field(SensorsDataParams.AIR_HUMIDITY)
  private int airHumidityData;

  @Field(SensorsDataParams.AIR_PHOTO)
  private int airPhotoData;

  @Field(SensorsDataParams.AIR_RADIATION)
  private int airRadiationData;

  @PersistenceConstructor
  public AirSampleData(
          @JsonProperty(SensorsDataParams.AIR_TEMPERATURE) int airTemperatureData,
          @JsonProperty(SensorsDataParams.AIR_HUMIDITY) int airHumidityData,
          @JsonProperty(SensorsDataParams.AIR_PHOTO) int airPhotoData,
          @JsonProperty(SensorsDataParams.AIR_RADIATION) int airRadiationData) {

    this.airTemperatureData = airTemperatureData;
    this.airHumidityData = airHumidityData;
    this.airPhotoData = airPhotoData;
    this.airRadiationData = airRadiationData;
  }
}