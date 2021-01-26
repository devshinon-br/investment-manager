package com.keyla.rezende.service.servicesImplementation

import com.keyla.rezende.model.CarteiraModel
import com.keyla.rezende.repository.CarteiraRepository
import com.keyla.rezende.service.CarteiraService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarteiraServiceImp implements CarteiraService{

    @Autowired
    CarteiraRepository carteiraRepository

    @Override
    List<CarteiraModel> findAll(){
        return  carteiraRepository.findAll()
    }

    @Override
    CarteiraModel findById(long id){
        return carteiraRepository.findById(id)
    }

    @Override
    CarteiraModel save(CarteiraModel carteira){
        return carteiraRepository.save(carteira)
    }

    @Override
    List<Object> getTotalAcoes(Date dataInicio, Date dataFim){
        return carteiraRepository.getTotalAcoes(dataInicio, dataFim)
    }

    @Override
    List<Object> getValorTotal(Date dataInicio, Date dataFim){
        return carteiraRepository.getValorTotal(dataInicio, dataFim)
    }

    @Override
    List<Object> getRendimento(Date dataInicio, Date dataFim){
        return carteiraRepository.getRendimento(dataInicio, dataFim)
    }

}
