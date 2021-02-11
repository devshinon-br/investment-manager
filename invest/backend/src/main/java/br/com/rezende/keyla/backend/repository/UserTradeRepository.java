package br.com.rezende.keyla.backend.repository;

import br.com.rezende.keyla.backend.model.UserTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserTradeRepository extends JpaRepository<UserTrade, Long> {

    public List<UserTrade> findByInstrument(String instrument);

    @Query("SELECT SUM(CASE WHEN ut.tipo_operacao = 'V' THEN (ut.quantidade * -1) " +
            "WHEN ut.tipo_operacao = 'C' THEN ut.quantidade END) " +
            "FROM UserTrade ut " +
            "WHERE ut.instrument = :instrument AND ut.data " +
            "BETWEEN :dataInicial AND :dataFinal")
    public Long findQuantidadeByInstrumentAndData(@Param("instrument") String instrument,
           @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);
}
