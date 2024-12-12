package org.example.service;

import org.example.model.Pizza;

import java.util.List;

public interface PizzaService {

    Pizza save(Pizza pizza);

    List<Pizza> findAll();
}
