package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Collection;

@Document(collection = "sinks_data")
@Data
public class SinkData implements Serializable, Cloneable {

    @Id
    private String id;

    @Field(value = SensorsDataParams.SINK_ID)
    private String sinkId;

    @Field(value = SensorsDataParams.SINK_SAMPLES)
    private Collection<NodeData> samples;

    @PersistenceConstructor
    public SinkData(
            @JsonProperty(SensorsDataParams.SINK_ID) String sinkId,
            @JsonProperty(SensorsDataParams.SINK_SAMPLES) Collection<NodeData> samples
    ) {

        this.sinkId = sinkId;
        this.samples = samples;
    }
}