package com.erbal.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeData {

  private String nodeId;
  private String timestamp;
  private String type;
  private String sectorId;
  private int voltage;
  private SampleData sample;
}