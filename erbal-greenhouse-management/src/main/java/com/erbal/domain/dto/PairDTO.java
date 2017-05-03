package com.erbal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PairDTO {

    private String sinkId;
    private String nodeId;
    private String sector;
    private String description;
}