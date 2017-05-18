package com.erbal.service;

import com.erbal.domain.Pair;
import com.erbal.exception.AlreadyPairedException;
import com.erbal.exception.AlreadyUnpairedException;
import domain.dto.MessageDTO;

public interface PairingService {

    MessageDTO<Pair> pair(Pair pair) throws AlreadyPairedException;
    MessageDTO<Pair> unpair(Pair pair) throws AlreadyUnpairedException;
}