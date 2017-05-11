package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Collection;

@Document(collection = "sinks_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinkData extends AuditEntity {

    @Field(value = SensorsDataParams.SINK_ID)
    private String sinkId;

    @Field(value = SensorsDataParams.SINK_SAMPLES)
    private Collection<NodeData> samples;
}