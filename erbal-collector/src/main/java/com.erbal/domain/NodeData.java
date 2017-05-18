package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeData {

  @Field(SensorsDataParams.NODE_ID)
  private String nodeId;

  @Field(SensorsDataParams.NODE_TIMESTAMP)
  private String timestamp;

  @Field(SensorsDataParams.NODE_TYPE)
  private String type;

  @Field(SensorsDataParams.NODE_SECTOR_ID)
  private String sectorId;

  @Field(SensorsDataParams.NODE_VOLTAGE)
  private int voltage;

  @Field(SensorsDataParams.NODE_SAMPLE)
  private SampleData sample;
}