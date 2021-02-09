package br.com.rezende.keyla.backend.repository;

import br.com.rezende.keyla.backend.model.InstrumentQuote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentQuoteRepository extends JpaRepository<InstrumentQuote, Long> {
}
