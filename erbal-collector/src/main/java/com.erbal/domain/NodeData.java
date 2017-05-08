package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
public class NodeData implements Serializable, Cloneable {

  @Field(SensorsDataParams.NODE_ID)
  private String nodeId;

  @Field(SensorsDataParams.NODE_TIMESTAMP)
  private String timestamp;

  @Field(SensorsDataParams.NODE_TYPE)
  private String type;

  @Field(SensorsDataParams.NODE_VOLTAGE)
  private int voltage;

  @Field(SensorsDataParams.NODE_SAMPLE)
  private SampleData sample;

  @PersistenceConstructor
  public NodeData(
          @JsonProperty(SensorsDataParams.NODE_ID) String nodeId,
          @JsonProperty(SensorsDataParams.NODE_TIMESTAMP) String timestamp,
          @JsonProperty(SensorsDataParams.NODE_VOLTAGE) int voltage,
          @JsonProperty(SensorsDataParams.NODE_SAMPLE) SampleData sample) {

    this.nodeId = nodeId;
    this.timestamp = timestamp;
    this.voltage = voltage;
    this.sample = sample;
  }
}