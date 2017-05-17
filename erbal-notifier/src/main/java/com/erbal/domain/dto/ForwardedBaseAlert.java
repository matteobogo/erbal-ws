package com.erbal.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForwardedBaseAlert {

    private String sinkId;
    private String nodeId;
    private String greenhouseName;
    private String nodeType;
}