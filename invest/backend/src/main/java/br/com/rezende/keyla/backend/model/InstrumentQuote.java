package br.com.rezende.keyla.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "instrument_quote")
public class InstrumentQuote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String simbol;

    @Column(columnDefinition = "NUMERIC(16,2)")
    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    public InstrumentQuote(String simbol, Double price, LocalDate date) {
        this.simbol = simbol;
        this.price = price;
        this.date = date;
    }

    public InstrumentQuote(){}

    @Override
    public String toString() {
        return "InstrumentQuote{" +
                "id=" + id +
                ", simbol='" + simbol + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
