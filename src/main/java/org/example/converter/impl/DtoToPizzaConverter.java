package org.example.converter.impl;

import org.example.model.Pizza;
import org.example.web.dto.PizzaDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToPizzaConverter implements Converter<PizzaDto, Pizza> {

    @Override
    public Pizza convert(PizzaDto pizzaDto){
        return Pizza.builder()
                .id(pizzaDto.getId())
                .name(pizzaDto.getName())
                .price(pizzaDto.getPrice())
                .build();
    }
}
