package controller;

import domain.dto.PairDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.PairingService;

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
  public PairDTO pair(
          @RequestBody @Valid PairDTO pairDTO) {

    return pairingService.pair(pairDTO);
  }

  @RequestMapping(
          value = "/unpair",
          method = RequestMethod.POST,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public PairDTO unpair(
          @RequestBody @Valid PairDTO pairDTO) {

    return pairingService.unpair(pairDTO);
  }

  @RequestMapping(
          value = "/dummy",
          method = RequestMethod.GET,
          consumes = {"application/json"}
  )
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public PairDTO dummy() {

    return new PairDTO(
            "123456789",
            "1122334455",
            "A",
            "error message"
    );
  }
}