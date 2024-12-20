package org.example.web.controller;

import org.example.facade.PizzaFacade;
import org.example.web.dto.CreatePizzaDto;
import org.example.web.dto.PizzaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaFacade pizzaFacade;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PizzaDto save(@RequestBody CreatePizzaDto createPizzaDto) {
        return pizzaFacade.save(createPizzaDto);
    }

    @GetMapping
    public List<PizzaDto> findAll() {
        return pizzaFacade.findAll();
    }

    @GetMapping("/{id}")
    public PizzaDto findById(@PathVariable Integer id) {
        return pizzaFacade.findById(id);
    }

    @PutMapping
    public PizzaDto update(@RequestBody PizzaDto pizzaDto) {
        return pizzaFacade.update(pizzaDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pizzaFacade.delete(id);
    }
}
