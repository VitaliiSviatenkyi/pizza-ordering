package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.example.model.enums.PizzaName;

import java.math.BigDecimal;

@Entity
@Table
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private PizzaName name;

    private BigDecimal price;

    public Pizza() {
    }

    public Pizza(PizzaName name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PizzaName getName() {
        return name;
    }

    public void setName(PizzaName name) {
        this.name = name;
    }
}
