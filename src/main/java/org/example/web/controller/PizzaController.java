package org.example.web.controller;

import org.example.facade.PizzaFacade;
import org.example.web.dto.CreatePizzaDto;
import org.example.web.dto.PizzaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    @Autowired
    private PizzaFacade pizzaFacade;

    @PostMapping
    public PizzaDto save(@RequestBody CreatePizzaDto createPizzaDto) {
        return pizzaFacade.save(createPizzaDto);
    }

    @GetMapping
    public List<PizzaDto> findAll() {
        return pizzaFacade.findAll();
    }
}
