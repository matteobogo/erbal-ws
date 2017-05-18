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

  private int airTemperatureData;
  private int airHumidityData;
  private int airPhotoData;
  private int airRadiationData;
}