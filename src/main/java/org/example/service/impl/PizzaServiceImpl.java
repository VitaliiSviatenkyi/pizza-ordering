package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Pizza;
import org.example.repository.PizzaRepository;
import org.example.service.PizzaService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }
}
