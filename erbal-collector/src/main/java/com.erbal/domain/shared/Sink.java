package com.erbal.domain.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sink {

    private String id;
    private String sinkId;
    private String greenhouseName;
    private String userId;
}