package br.com.rezende.keyla.backend.services.servicesImp;

import br.com.rezende.keyla.backend.model.InstrumentQuote;
import br.com.rezende.keyla.backend.repository.InstrumentQuoteRepository;
import br.com.rezende.keyla.backend.services.InstrumentQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentQuoteImp implements InstrumentQuoteService {

    @Autowired
    InstrumentQuoteRepository instrumentQuoteRepository;

    @Override
    public List<InstrumentQuote> findAll(){
        return instrumentQuoteRepository.findAll();
    }

    @Override
    public InstrumentQuote findById(Long id){
        return instrumentQuoteRepository.findById(id).get();
    }

    @Override
    public InstrumentQuote save( InstrumentQuote instrumentQuote){
        return instrumentQuoteRepository.save(instrumentQuote);
    }

    @Override
    public List<InstrumentQuote> findBySimbol(String simbol){return instrumentQuoteRepository.findBySimbol(simbol);}
}
