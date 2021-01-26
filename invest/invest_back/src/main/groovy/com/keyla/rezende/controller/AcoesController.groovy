package com.keyla.rezende.controller

import com.keyla.rezende.model.AcoesModel
import com.keyla.rezende.service.AcoesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class AcoesController {

    @Autowired
    AcoesService acoesService;

    @GetMapping("/acoes")
    public List<AcoesModel> getAcoes(){
        List<AcoesModel> acoes = acoesService.findAll();
        return acoes;
    }
}
