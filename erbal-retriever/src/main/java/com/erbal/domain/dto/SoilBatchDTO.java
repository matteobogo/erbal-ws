package com.erbal.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class SoilBatchDTO {

    @JsonProperty("temperature")
    private TemperatureDTO temperatureDTO;
    @JsonProperty("moisture")
    private MoistureDTO moistureDTO;

    public SoilBatchDTO() {
        this.temperatureDTO = new TemperatureDTO(new ArrayList<>());
        this.moistureDTO = new MoistureDTO(new ArrayList<>());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class TemperatureDTO {

        @JsonProperty("timestampValues")
        private List<TimestampValueDTO> timestampValueDTOList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MoistureDTO {

        @JsonProperty("timestampValues")
        private List<TimestampValueDTO> timestampValueDTOList;
    }
}