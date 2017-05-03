package com.erbal.service;

import com.erbal.domain.dto.PairDTO;

public interface PairingService {

    PairDTO pair(PairDTO pairDTO);
    PairDTO unpair(PairDTO pairDTO);
}