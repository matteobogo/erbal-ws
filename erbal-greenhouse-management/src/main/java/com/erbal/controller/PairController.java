package com.erbal.controller;

import com.erbal.domain.Pair;
import com.erbal.domain.dto.MessageDTO;
import com.erbal.domain.dto.SinkTable;
import com.erbal.service.PairingService;
import com.erbal.service.SinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
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
          value = "pair/dummy",
          method = RequestMethod.GET
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public Pair pairDummy() {

    return new Pair(
            "123456789",
            "1122334455",
            "A"
    );
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