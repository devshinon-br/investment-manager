package br.com.rezende.keyla.backend.services;

import br.com.rezende.keyla.backend.model.InstrumentQuote;
import java.util.List;

public interface InstrumentQuoteService {
    List<InstrumentQuote> findAll();

    InstrumentQuote findById(Long id);

    InstrumentQuote save( InstrumentQuote instrumentQuote);
}
