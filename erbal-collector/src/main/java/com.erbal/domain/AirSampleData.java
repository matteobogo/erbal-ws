package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirSampleData extends SampleData {

  @Field(SensorsDataParams.AIR_TEMPERATURE)
  private double airTemperatureData;

  @Field(SensorsDataParams.AIR_HUMIDITY)
  private double airHumidityData;

  @Field(SensorsDataParams.AIR_PHOTO)
  private double airPhotoData;

  @Field(SensorsDataParams.AIR_RADIATION)
  private double airRadiationData;
}