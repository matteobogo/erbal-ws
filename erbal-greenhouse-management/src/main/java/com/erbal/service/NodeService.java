package com.erbal.service;

import com.erbal.domain.Node;

public interface NodeService extends CrudService<Node> {

    String findSectorIdByNodeId(String nodeId);
}