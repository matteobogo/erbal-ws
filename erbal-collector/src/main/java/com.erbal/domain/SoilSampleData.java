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
public class SoilSampleData extends SampleData {

  @Field(SensorsDataParams.SOIL_TEMPERATURE)
  private int soilTemperatureData;

  @Field(SensorsDataParams.SOIL_MOISTURE)
  private int soilMoistureData;
}