package br.com.rezende.keyla.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "user_trade")
public class UserTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data;

    private String tipo_operacao;

    private String mercado;

    private String prazo;

    private String instrument;

    private String especificacao;

    private int quantidade;

    @Column(columnDefinition = "NUMERIC(16,2)")
    private Double preco;

    @Column(columnDefinition = "NUMERIC(16,2)")
    private Double valor_total;

    public UserTrade(){}

    public UserTrade(LocalDate data, String tipo_operacao, String mercado, String prazo,
                     String instrument, String especificacao, int quantidade, Double preco,
                     Double valor_total) {
        this.data = data;
        this.tipo_operacao = tipo_operacao;
        this.mercado = mercado;
        this.prazo = prazo;
        this.instrument = instrument;
        this.especificacao = especificacao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valor_total = valor_total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public String toString() {
        return "UserTrade{" +
                "id=" + id +
                ", data=" + data +
                ", tipo_operacao='" + tipo_operacao + '\'' +
                ", mercado='" + mercado + '\'' +
                ", prazo='" + prazo + '\'' +
                ", instrument='" + instrument + '\'' +
                ", especificacao='" + especificacao + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", valor_total=" + valor_total +
                '}';
    }


}
