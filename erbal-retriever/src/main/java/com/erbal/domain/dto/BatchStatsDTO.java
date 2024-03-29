package com.erbal.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchStatsDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("soilBatches")
    private SoilBatchDTO soilBatchDTOList;
    @JsonProperty("outdoorBatches")
    private OutdoorBatchDTO outdoorBatchDTOList;
    @JsonProperty("indoorBatches")
    private IndoorBatchDTO indoorBatchDTOList;
}