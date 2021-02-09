package br.com.rezende.keyla.backend.controller;

import br.com.rezende.keyla.backend.model.UserTrade;
import br.com.rezende.keyla.backend.services.UserTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<UserTrade> agrupadoPorInstrument = userTradeService.findByInstrument(instrument);
        return agrupadoPorInstrument;
    }
}
