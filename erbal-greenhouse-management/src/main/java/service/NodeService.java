package service;

import domain.Node;

import java.util.List;

public interface NodeService {

    Node add(Node node);
    Node update(Node node);
    List<Node> getAll();
    Node getNodeBySerialId(String serialId);
    Node deleteBySerialId(String serialId);

}