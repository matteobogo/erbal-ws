package com.erbal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItsMeResponse {

    private String nodeId;
    private boolean isPaired;

    public ItsMeResponse(String nodeId) {
        this.nodeId = nodeId;
    }
}