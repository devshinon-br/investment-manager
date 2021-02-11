package br.com.rezende.keyla.backend.repository;

import br.com.rezende.keyla.backend.model.InstrumentQuote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrumentQuoteRepository extends JpaRepository<InstrumentQuote, Long> {
    public List<InstrumentQuote> findBySimbol(String simbol);
}
