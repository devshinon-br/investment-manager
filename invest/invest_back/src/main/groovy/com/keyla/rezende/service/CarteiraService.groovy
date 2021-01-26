package com.keyla.rezende.service

import com.keyla.rezende.model.CarteiraModel

interface CarteiraService {

    List<CarteiraModel> findAll();

    CarteiraModel findById(long id);

    CarteiraModel save( CarteiraModel carteira);

    List<Object>  getTotalAcoes(Date dataInicio, Date dataFim);

    List<Object>  getValorTotal(Date dataInicio, Date dataFim);

    List<Object>  getRendimento(Date dataInicio, Date dataFim);

}