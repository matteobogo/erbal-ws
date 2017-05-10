package com.erbal.service;

import com.erbal.domain.Pair;
import com.erbal.domain.shared.MessageDTO;

public interface PairingService {

    void pair(Pair pair);
    void unpair(Pair pair);
}