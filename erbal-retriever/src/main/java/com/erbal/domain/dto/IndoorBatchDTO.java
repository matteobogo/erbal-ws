package com.erbal.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class IndoorBatchDTO {

    @JsonProperty("airTemperature")
    private AirTemperatureDTO airTemperatureDTO;
    @JsonProperty("airHumidity")
    private AirHumidityDTO airHumidityDTO;
    @JsonProperty("airPhoto")
    private AirPhoto airPhoto;
    @JsonProperty("airRadiation")
    private AirRadiation airRadiation;

    public IndoorBatchDTO() {

        this.airTemperatureDTO = new AirTemperatureDTO(new ArrayList<>());
        this.airHumidityDTO = new AirHumidityDTO(new ArrayList<>());
        this.airPhoto = new AirPhoto(new ArrayList<>());
        this.airRadiation = new AirRadiation(new ArrayList<>());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AirTemperatureDTO {

        @JsonProperty("timestampValues")
        private List<TimestampValueDTO> timestampValueDTOList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AirHumidityDTO {

        @JsonProperty("timestampValues")
        private List<TimestampValueDTO> timestampValueDTOList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AirPhoto {

        @JsonProperty("timestampValues")
        private List<TimestampValueDTO> timestampValueDTOList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AirRadiation {

        @JsonProperty("timestampValues")
        private List<TimestampValueDTO> timestampValueDTOList;
    }
}