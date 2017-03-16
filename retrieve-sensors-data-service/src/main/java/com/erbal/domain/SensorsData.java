package com.erbal.domain;

import lombok.Getter;

public abstract class SensorsData extends AuditEntity<String> {

    @Getter
    private final String terrainSectorId;

    protected SensorsData(
            String terrainSectorId) {

        this.terrainSectorId = terrainSectorId;
    }
}