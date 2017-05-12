package com.erbal.service;

import com.erbal.domain.Pair;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.exception.AlreadyPairedException;
import com.erbal.exception.AlreadyUnpairedException;

public interface PairingService {

    MessageDTO<Pair> pair(Pair pair) throws AlreadyPairedException;
    MessageDTO<Pair> unpair(Pair pair) throws AlreadyUnpairedException;
}