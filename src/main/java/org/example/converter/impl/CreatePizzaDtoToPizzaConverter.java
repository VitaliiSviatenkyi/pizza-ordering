package org.example.converter.impl;

import org.example.model.Pizza;
import org.example.web.dto.CreatePizzaDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreatePizzaDtoToPizzaConverter implements Converter<CreatePizzaDto, Pizza> {

    @Override
    public Pizza convert(CreatePizzaDto createPizzaDto) {
        return Pizza.builder()
                .name(createPizzaDto.getName())
                .price(createPizzaDto.getPrice())
                .build();
    }
}
