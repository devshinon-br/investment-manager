package com.keyla.rezende.repository

import com.keyla.rezende.model.CarteiraModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface CarteiraRepository extends JpaRepository<CarteiraModel, Long> {

    @Query( value = "SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END) as quantidade FROM user_trade WHERE data BETWEEN :dataInicio AND :dataFim GROUP BY instrument", nativeQuery = true)
    List<Object> getTotalAcoes(@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim)

    @Query(value = "SELECT SUM(quantidade * price), date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END) as quantidade FROM user_trade WHERE data BETWEEN :dataInicio AND :dataFim GROUP BY instrument) total_acoes left join instrument_quote ON simbol = instrument WHERE date BETWEEN :dataInicio AND :dataFim GROUP BY date ORDER BY date", nativeQuery = true)
    List<Object> getValorTotal(@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim)

    @Query(value = """SELECT quantidade, valor_total_acoes, rendimento_dinheiro, rendimento_porcentagem, tb_qtd.data FROM
(SELECT SUM(valor_total_acoes * ((valor_total_acoes - total_investido) / total_investido)) as rendimento_dinheiro, SUM((valor_total_acoes - total_investido) / total_investido) as rendimento_porcentagem, data FROM
(SELECT total_investido, data FROM (SELECT SUM(CASE WHEN tipo_operacao = 'C' THEN valor_total ELSE valor_total * -1 END)
OVER (ORDER BY data ASC) as total_investido, data FROM user_trade) tb_total_investido GROUP BY data, total_investido ORDER BY data) ti
join
(SELECT SUM(quantidade * price) as valor_total_acoes, date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
as quantidade FROM user_trade GROUP BY instrument) total_acoes
left join instrument_quote ON simbol = instrument GROUP BY date ORDER BY date) tva
ON data = date GROUP BY data) tb_rendimento
left join
(SELECT SUM(quantidade * price) as valor_total_acoes, date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
as quantidade FROM user_trade GROUP BY instrument) total_acoes
left join instrument_quote ON simbol = instrument GROUP BY date ORDER BY date) tb_total ON tb_rendimento.data = tb_total.date
left join
(SELECT * FROM (SELECT data, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
OVER (ORDER BY data ASC) as quantidade FROM user_trade) tb_qtd_aux GROUP BY data, quantidade ORDER BY data) tb_qtd ON tb_qtd.data = tb_total.date WHERE tb_qtd.data BETWEEN :dataInicio AND :dataFim""", nativeQuery = true)
    List<Object> getRendimento(@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim)


    //Rendimento Geral
    //SELECT quantidade, valor_total_acoes, rendimento, tb_qtd.data FROM
    //(SELECT SUM((valor_total_acoes - total_investido) / total_investido) as rendimento, data FROM
    //(SELECT total_investido, data FROM (SELECT SUM(CASE WHEN tipo_operacao = 'C' THEN valor_total ELSE valor_total * -1 END)
    //OVER (ORDER BY data ASC) as total_investido, data FROM user_trade) tb_total_investido GROUP BY data, total_investido ORDER BY data) ti
    //join
    //(SELECT SUM(quantidade * price) as valor_total_acoes, date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
    //as quantidade FROM user_trade GROUP BY instrument) total_acoes
    //left join instrument_quote ON simbol = instrument GROUP BY date ORDER BY date) tva
    //ON data = date GROUP BY data) tb_rendimento
    //left join
    //(SELECT SUM(quantidade * price) as valor_total_acoes, date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
    //as quantidade FROM user_trade GROUP BY instrument) total_acoes
    //left join instrument_quote ON simbol = instrument GROUP BY date ORDER BY date) tb_total ON tb_rendimento.data = tb_total.date
    //left join
    //(SELECT * FROM (SELECT data, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
    //OVER (ORDER BY data ASC) as quantidade FROM user_trade) tb_qtd_aux GROUP BY data, quantidade ORDER BY data) tb_qtd ON tb_qtd.data = tb_total.date;

    //RENDIMENTO
    //SELECT SUM((valor_total_acoes - total_investido) / total_investido) as rendimento, data FROM
    //(SELECT total_investido, data FROM (SELECT SUM(CASE WHEN tipo_operacao = 'C' THEN valor_total ELSE valor_total * -1 END)
    //OVER (ORDER BY data ASC) as total_investido, data FROM user_trade) tb_total_investido GROUP BY data, total_investido ORDER BY data) ti
    //join
    //(SELECT SUM(quantidade * price) as valor_total_acoes, date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
    //as quantidade FROM user_trade WHERE data BETWEEN '1999/01/01' AND '2050/02/01' GROUP BY instrument) total_acoes
    //left join instrument_quote ON simbol = instrument WHERE date BETWEEN '1999/01/01' AND '2050/02/01' GROUP BY date ORDER BY date) tva
    //ON data = date GROUP BY data;

    //Investimento Total
    //SELECT total_investido, data FROM (SELECT SUM(CASE WHEN tipo_operacao = 'C' THEN valor_total ELSE valor_total * -1 END)
    //OVER (ORDER BY data ASC) as total_investido, data FROM user_trade) tb_total_investido GROUP BY data, total_investido ORDER BY data

    //Total na carteira por dia
    //SELECT SUM(quantidade * price) as valor_total_acoes, date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END)
    //as quantidade FROM user_trade WHERE data BETWEEN '2019/01/01' AND '2020/02/01' GROUP BY instrument) total_acoes
    //left join instrument_quote ON simbol = instrument WHERE date BETWEEN '2019/01/01' AND '2020/02/01' GROUP BY date ORDER BY date

    //Total por acao/instrument e data
    //SELECT instrument, SUM(quantidade * price), date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END) as quantidade FROM user_trade WHERE data BETWEEN '2019/01/01' AND '2020/02/01' GROUP BY instrument) total_acoes left join instrument_quote ON simbol = instrument WHERE date BETWEEN '2019/01/01' AND '2020/02/01' GROUP BY date, instrument ORDER BY date

    //Total por data
    //SELECT SUM(quantidade * price), date FROM (SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END) as quantidade FROM user_trade WHERE data BETWEEN '2019/01/01' AND '2020/02/01' GROUP BY instrument) total_acoes left join instrument_quote ON simbol = instrument WHERE date BETWEEN '2019/01/01' AND '2020/02/01' GROUP BY date ORDER BY date

    // TOTAL ACOES
    //SELECT instrument, SUM(CASE WHEN tipo_operacao = 'C' THEN quantidade ELSE quantidade * -1 END) as quantidade FROM user_trade GROUP BY instrument

    //Total comprado por ações
    //SELECT SUM(quantidade) as quantidade, instrument FROM user_trade WHERE tipo_operacao = 'C' GROUP BY instrument

    //Total vendido por ações
    //SELECT SUM(quantidade) as quantidade, instrument FROM user_trade WHERE tipo_operacao = 'V' GROUP BY instrument

}