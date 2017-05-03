package service;

import domain.dto.PairDTO;

public interface PairingService {

    PairDTO pair(PairDTO pairDTO);
    PairDTO unpair(PairDTO pairDTO);
}