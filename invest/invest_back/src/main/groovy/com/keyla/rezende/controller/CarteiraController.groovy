package com.keyla.rezende.controller

import com.keyla.rezende.model.CarteiraModel
import com.keyla.rezende.service.CarteiraService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
class CarteiraController {
    @Autowired
    CarteiraService carteiraService

    @GetMapping("/carteiras")
    List<CarteiraModel> getCarteira(){
        List<CarteiraModel> carteiras = carteiraService.findAll()
        return carteiras
    }

    @GetMapping("/acoesTotal")
    List<Object> getAcoes(@RequestParam ( value = "dataInicio", defaultValue = "1999/01/01", required = false) Date dataInicio, @RequestParam(value = "dataFim", defaultValue = "2020/12/13", required = false) Date dataFim){
        List<Object> totalAcoes = carteiraService.getTotalAcoes(dataInicio, dataFim)
        return totalAcoes
    }

    @GetMapping("/valorTotal")
    List<Object> getValor(@RequestParam ( value = "dataInicio", defaultValue = "1999/01/01", required = false) Date dataInicio, @RequestParam(value = "dataFim", defaultValue = "2020/12/13", required = false) Date dataFim){
        List<Object> valorTotal = carteiraService.getValorTotal(dataInicio, dataFim)
        return valorTotal
    }

    @GetMapping("/rendimento")
    List<Object> getRendimentoTotal(@RequestParam ( value = "dataInicio", defaultValue = "1999/01/01", required = false) Date dataInicio, @RequestParam(value = "dataFim", defaultValue = "2050/12/13", required = false) Date dataFim){
        List<Object> rendimento = carteiraService.getRendimento(dataInicio, dataFim)
        return rendimento
    }

}
