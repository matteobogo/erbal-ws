package com.erbal.service;

import com.erbal.domain.Pair;
import com.erbal.domain.dto.MessageDTO;

public interface PairingService {

    MessageDTO<Pair> pair(Pair pair);
    MessageDTO<Pair> unpair(Pair pair);
}