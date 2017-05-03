package domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import utils.GreenhouseManagementParams;

@Document(collection = "nodes")
@Data
public class Node extends BaseEntity {

    @Id
    private String id;

    @Indexed
    @Field(GreenhouseManagementParams.NODE_SERIAL_ID)
    private String serialId;

    @Field(GreenhouseManagementParams.NODE_TYPE)
    private String type;

    @Field(GreenhouseManagementParams.NODE_SECTOR)
    private String sector;

    @DBRef
    private Sink sink;

    @PersistenceConstructor
    public Node(
            @JsonProperty(GreenhouseManagementParams.NODE_SERIAL_ID) String serialId,
            @JsonProperty(GreenhouseManagementParams.NODE_TYPE) String type,
            @JsonProperty(GreenhouseManagementParams.NODE_SECTOR) String sector
    ) {
        this.serialId = serialId;
        this.type = type;
        this.sector = sector;
    }
}