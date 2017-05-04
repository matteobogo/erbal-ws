package com.erbal.controller;

import com.erbal.domain.Pair;
import com.erbal.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.erbal.service.PairingService;

import javax.validation.Valid;

@RestController
public class PairController extends ExceptionHandlingController {

  private PairingService pairingService;

  @Autowired
  public PairController(PairingService pairingService) { this.pairingService = pairingService; }

  @RequestMapping(
          value = "/pair",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public MessageDTO<Pair> pair(
          @RequestBody @Valid Pair pairDTO) {

    return pairingService.pair(pairDTO);
  }

  @RequestMapping(
          value = "/unpair",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public MessageDTO<Pair> unpair(
          @RequestBody @Valid Pair pairDTO) {

    return pairingService.unpair(pairDTO);
  }

  @RequestMapping(
          value = "/dummy",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Pair dummy() {

    return new Pair(
            "123456789",
            "1122334455",
            "A"
    );
  }
}