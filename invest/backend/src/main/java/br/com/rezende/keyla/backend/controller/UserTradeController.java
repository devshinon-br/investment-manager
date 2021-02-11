package br.com.rezende.keyla.backend.controller;

import br.com.rezende.keyla.backend.model.UserTrade;
import br.com.rezende.keyla.backend.services.UserTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/carteira_investidor")
public class UserTradeController {

    @Autowired
    UserTradeService userTradeService;

    @GetMapping("/investimentos")
    public List<UserTrade> getAllUserTrade(){
        List<UserTrade> investimentos = userTradeService.findAll();
        return investimentos;
    }

    @GetMapping("/{instrument}")
    public List<UserTrade> getUserTradeByInstrument(@PathVariable String instrument){
        List<UserTrade> agrupadoPorInstrument = userTradeService
                .findByInstrument(instrument);
        return agrupadoPorInstrument;
    }

    @GetMapping("/quantidade/{instrument}")
    public Long getQuantidadeByInstrument(@PathVariable String instrument,
           @RequestParam(name = "dataInicial", required = false, defaultValue = "1899-12-31")
           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
           @RequestParam(name = "dataFinal", required = true)
           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal){
        Long quantidadeAgrupadaPorInstrument = userTradeService
                .findQuantidadeByInstrumentAndData(instrument, dataInicial, dataFinal);
        return quantidadeAgrupadaPorInstrument;
    }
}
