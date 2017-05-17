package com.erbal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomingBaseAlert {

    @NotNull(message = "Sink Serial ID is compulsory")
    @NotBlank(message = "Sink Serial ID is compulsory")
    private String sinkId;

    @NotNull(message = "Node Serial ID is compulsory")
    @NotBlank(message = "Node Serial ID is compulsory")
    private String nodeId;

    @NotNull(message = "Node Type is compulsory")
    @NotBlank(message = "Node Type is compulsory")
    private String type;
}