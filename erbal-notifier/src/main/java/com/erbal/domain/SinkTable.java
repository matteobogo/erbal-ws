package com.erbal.domain;

import com.erbal.domain.shared.Node;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class SinkTable implements Serializable {

  private String sinkId;
  private List<Node> nodes;

  public SinkTable(
          @JsonProperty("sink_id") String sinkId,
          @JsonProperty("nodes") List<Node> nodes) {

    this.sinkId = sinkId;
    this.nodes = nodes;
  }
}