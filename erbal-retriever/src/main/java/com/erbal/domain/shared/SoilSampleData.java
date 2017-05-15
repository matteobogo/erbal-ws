package com.erbal.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoilSampleData extends SampleData {

  private int soilTemperatureData;
  private int soilMoistureData;
}