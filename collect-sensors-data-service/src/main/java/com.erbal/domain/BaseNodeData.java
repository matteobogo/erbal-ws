package com.erbal.domain;

import com.erbal.utils.SensorsDataParams;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "NodesData")
@Data
public abstract class BaseNodeData {

    @Id
    private String id;

    @Field(SensorsDataParams.SENSOR_ID)
    private String sensorId;
}