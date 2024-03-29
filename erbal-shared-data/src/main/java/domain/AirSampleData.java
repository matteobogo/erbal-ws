package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirSampleData extends SampleData {

  private double airTemperatureData;
  private double airHumidityData;
  private double airPhotoData;
  private double airRadiationData;
}