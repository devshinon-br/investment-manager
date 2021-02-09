package br.com.rezende.keyla.backend.controller;

import br.com.rezende.keyla.backend.model.UserTrade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteira_investidor")
public class UserTradeController {

    @GetMapping("/total")
    public UserTrade getAllUserTrade(){
        return new UserTrade();
    }
}
