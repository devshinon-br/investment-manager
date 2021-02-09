package br.com.rezende.keyla.backend.repository;

import br.com.rezende.keyla.backend.model.UserTrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTradeRepository extends JpaRepository<UserTrade, Long> {
}
