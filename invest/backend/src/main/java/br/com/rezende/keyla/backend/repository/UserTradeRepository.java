package br.com.rezende.keyla.backend.repository;

import br.com.rezende.keyla.backend.model.UserTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserTradeRepository extends JpaRepository<UserTrade, Long> {

    public List<UserTrade> findByInstrument(String instrument);
}
