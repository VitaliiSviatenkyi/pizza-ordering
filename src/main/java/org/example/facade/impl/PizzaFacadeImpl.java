package org.example.facade.impl;

import lombok.RequiredArgsConstructor;
import org.example.facade.PizzaFacade;
import org.example.model.Pizza;
import org.example.service.PizzaService;
import org.example.web.dto.CreatePizzaDto;
import org.example.web.dto.PizzaDto;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaFacadeImpl implements PizzaFacade {

    private final PizzaService pizzaService;
    private final ConversionService conversionService;

    @Override
    public PizzaDto save(CreatePizzaDto createPizzaDto) {
        Pizza pizza = conversionService.convert(createPizzaDto, Pizza.class);
        pizza = pizzaService.save(pizza);
        return conversionService.convert(pizza, PizzaDto.class);
    }

    @Override
    public List<PizzaDto> findAll() {
        return pizzaService.findAll().stream().map(pizza -> conversionService.convert(pizza, PizzaDto.class))
                .collect(Collectors.toList());
    }
}
