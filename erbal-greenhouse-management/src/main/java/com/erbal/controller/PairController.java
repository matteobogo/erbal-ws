package com.erbal.controller;

import com.erbal.domain.Pair;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.domain.dto.SinkTable;
import com.erbal.exception.AlreadyPairedException;
import com.erbal.exception.AlreadyUnpairedException;
import com.erbal.service.PairingService;
import com.erbal.service.SinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@PreAuthorize("#oauth2.hasScope('server')")
@RequestMapping("/pairing")
public class PairController extends ExceptionHandlingController {

  private PairingService pairingService;
  private SinkService sinkService;

  @Autowired
  public PairController(
          PairingService pairingService,
          SinkService sinkService) {

    this.pairingService = pairingService;
    this.sinkService = sinkService;
  }

  @RequestMapping(
          value = "/pair",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public MessageDTO<Pair> pair(
          @RequestBody @Valid Pair pairDTO) throws AlreadyPairedException {

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
          @RequestBody @Valid Pair pairDTO) throws AlreadyUnpairedException {

    return pairingService.unpair(pairDTO);
  }

  @RequestMapping(
          value = "/table/{sinkId}",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus
  public SinkTable updateSinkTable(
          @PathVariable("sinkId") String sinkId) {

    return sinkService.updateSinkTable(sinkId);
  }
}