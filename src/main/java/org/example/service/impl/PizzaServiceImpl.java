package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.exception.EntityNotFoundException;
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

    @Override
    public Pizza findById(Integer id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pizza not found"));
    }

    @Override
    public Pizza update(Pizza pizza) {
        Pizza updatePizza = pizzaRepository.findById(pizza.getId())
                .orElseThrow(() -> new EntityNotFoundException("Pizza not found"));
        updatePizza.setName(pizza.getName());
        updatePizza.setPrice(pizza.getPrice());
        return pizzaRepository.save(updatePizza);
    }

    @Override
    public void delete(Integer id) {
        pizzaRepository.deleteById(id);
    }
}
