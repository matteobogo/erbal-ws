package com.erbal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "sampleDataType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AirSampleData.class, name = "AirSampleData"),
        @JsonSubTypes.Type(value = SoilSampleData.class, name = "SoilSampleData")
})
@Data
public abstract class SampleData {
  //
}