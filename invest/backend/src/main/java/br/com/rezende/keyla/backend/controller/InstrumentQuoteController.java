package br.com.rezende.keyla.backend.controller;

import br.com.rezende.keyla.backend.model.InstrumentQuote;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acoes")
public class InstrumentQuoteController {

    @GetMapping("/total")
    public InstrumentQuote getAllInstruments(){
        return new InstrumentQuote();
    }
}
