package com.erbal.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterSink {

    private String sinkId;
    private String userId;
    private String greenhouseName;
}