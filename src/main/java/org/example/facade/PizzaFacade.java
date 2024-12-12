package org.example.facade;

import org.example.web.dto.CreatePizzaDto;
import org.example.web.dto.PizzaDto;

import java.util.List;

public interface PizzaFacade {

    PizzaDto save(CreatePizzaDto createPizzaDto);

    List<PizzaDto> findAll();
}
