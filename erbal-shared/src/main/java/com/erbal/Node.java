package com.erbal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private String id;
    private String nodeId;
    private String type;
    private String sector;
    private Sink sink;
}