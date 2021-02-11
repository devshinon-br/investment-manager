package br.com.rezende.keyla.backend.controller;

import br.com.rezende.keyla.backend.model.InstrumentQuote;
import br.com.rezende.keyla.backend.model.UserTrade;
import br.com.rezende.keyla.backend.services.InstrumentQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class InstrumentQuoteController {

    @Autowired
    InstrumentQuoteService instrumentQuoteService;

    @GetMapping("/total")
    public List<InstrumentQuote> getAllInstruments(){
        List<InstrumentQuote> totalDeAcoes = instrumentQuoteService.findAll();
        return totalDeAcoes;
    }

    @GetMapping("/{simbol}")
    public List<InstrumentQuote> getUserTradeByInstrument(@PathVariable String simbol){
        List<InstrumentQuote> agrupadoPorSimbol = instrumentQuoteService.findBySimbol(simbol);
        return agrupadoPorSimbol;
    }
}
