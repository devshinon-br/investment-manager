package com.keyla.rezende.model
import com.fasterxml.jackson.annotation.JsonFormat

import javax.persistence.Column
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user_trade")
class CarteiraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = 'dd-MM-yyyy')
    private LocalDate data

    @NotBlank
    private String tipo_operacao

    @NotBlank
    private String mercado

    @NotBlank
    private String prazo

    @NotBlank
    private String instrument

    @NotBlank
    private String especificacao

    @NotBlank
    @Column(columnDefinition = "NUMERIC(11,0)")
    private int quantidade

    @NotBlank
    @Column(columnDefinition = "NUMERIC(16,2)")
    private double preco

    @NotBlank
    @Column(columnDefinition = "NUMERIC(16,2)")
    private double valor_total

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    LocalDate getData() {
        return data
    }

    void setData(LocalDate data) {
        this.data = data
    }

    String getTipo_operacao() {
        return tipo_operacao
    }

    void setTipo_operacao(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao
    }

    String getMercado() {
        return mercado
    }

    void setMercado(String mercado) {
        this.mercado = mercado
    }

    String getPrazo() {
        return prazo
    }

    void setPrazo(String prazo) {
        this.prazo = prazo
    }

    String getInstrument() {
        return instrument
    }

    void setInstrument(String instrument) {
        this.instrument = instrument
    }

    String getEspecificacao() {
        return especificacao
    }

    void setEspecificacao(String especificacao) {
        this.especificacao = especificacao
    }

    int getQuantidade() {
        return quantidade
    }

    void setQuantidade(int quantidade) {
        this.quantidade = quantidade
    }

    double getPreco() {
        return preco
    }

    void setPreco(double preco) {
        this.preco = preco
    }

    double getValor_total() {
        return valor_total
    }

    void setValor_total(double valor_total) {
        this.valor_total = valor_total
    }

    CarteiraModel(long id, LocalDate data, String tipo_operacao, String mercado, String prazo, String instrument, String especificacao, int quantidade, double preco, double valor_total) {
        this.id = id
        this.data = data
        this.tipo_operacao = tipo_operacao
        this.mercado = mercado
        this.prazo = prazo
        this.instrument = instrument
        this.especificacao = especificacao
        this.quantidade = quantidade
        this.preco = preco
        this.valor_total = valor_total
    }

    CarteiraModel() {}

    @Override
    public String toString() {
        return "CarteiraModel{" +
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
