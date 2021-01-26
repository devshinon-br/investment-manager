package com.keyla.rezende.service.servicesImplementation

import com.keyla.rezende.model.AcoesModel
import com.keyla.rezende.repository.AcoesRepository
import com.keyla.rezende.service.AcoesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AcoesServiceImp implements  AcoesService{

    @Autowired
    AcoesRepository acoesRepository;

    @Override
    public List<AcoesModel> findAll(){
        return acoesRepository.findAll();
    }

    @Override
    public AcoesModel findById(long id){
        return acoesRepository.findById(id).get();
    }

    @Override
    public AcoesModel save(AcoesModel acoes){
        return acoesRepository.save(acoes);
    }
}
