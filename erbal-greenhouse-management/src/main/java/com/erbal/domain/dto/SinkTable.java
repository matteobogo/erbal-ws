package com.erbal.domain.dto;

import com.erbal.domain.Node;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinkTable {

  private String sinkId;
  private String greenhouseName;
  private List<Node> nodes;
}