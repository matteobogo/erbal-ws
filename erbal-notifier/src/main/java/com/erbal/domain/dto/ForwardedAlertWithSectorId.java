package com.erbal.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class ForwardedAlertWithSectorId extends ForwardedBaseAlert {

    private String sectorId;

    public ForwardedAlertWithSectorId(
            String sinkId,
            String nodeId,
            String greenhouseName,
            String nodeType,
            String sectorId) {

        super(sinkId,nodeId,greenhouseName,nodeType);
        this.sectorId = sectorId;
    }
}