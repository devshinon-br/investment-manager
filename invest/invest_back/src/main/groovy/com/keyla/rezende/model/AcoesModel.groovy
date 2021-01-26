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
@Table(name="instrument_quote")
class AcoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id

    @NotBlank
    private String simbol

    @NotBlank
    @Column(columnDefinition = "NUMERIC(16,2)")
    private double price

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    String getSimbol() {
        return simbol
    }

    void setSimbol(String simbol) {
        this.simbol = simbol
    }

    double getPrice() {
        return price
    }

    void setPrice(double price) {
        this.price = price
    }

    LocalDate getDate() {
        return date
    }

    void setDate(LocalDate date) {
        this.date = date
    }

    AcoesModel(long id, String simbol, double price, LocalDate date) {
        this.id = id
        this.simbol = simbol
        this.price = price
        this.date = date
    }

    AcoesModel(){}

    @Override
    public String toString() {
        return "AcoesModel{" +
                "id=" + id +
                ", simbol='" + simbol + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
