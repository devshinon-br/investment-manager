package com.keyla.rezende.service

import com.keyla.rezende.model.AcoesModel


interface AcoesService {

    List<AcoesModel> findAll();

    AcoesModel findById(long id);

    AcoesModel save(AcoesModel acoes);
}