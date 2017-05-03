package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import utils.GreenhouseManagementParams;

@Document(collection = "sinks")
@Data
public class Sink extends BaseEntity {

    @Id
    private String id;

    @Indexed
    @Field(GreenhouseManagementParams.SINK_SERIAL_ID)
    private String serialId;

    @Field(GreenhouseManagementParams.SINK_GREENHOUSE_NAME)
    private String greenhouseName;

    @PersistenceConstructor
    public Sink(
            @JsonProperty(GreenhouseManagementParams.SINK_SERIAL_ID) String serialId,
            @JsonProperty(GreenhouseManagementParams.SINK_GREENHOUSE_NAME) String greenhouseName
    ) {
        this.serialId = serialId;
        this.greenhouseName = greenhouseName;
    }
}