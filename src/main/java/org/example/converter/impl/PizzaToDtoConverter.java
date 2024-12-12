package org.example.converter.impl;

import org.example.model.Pizza;
import org.example.web.dto.PizzaDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PizzaToDtoConverter implements Converter<Pizza, PizzaDto> {

    @Override
    public PizzaDto convert(Pizza pizza) {
        return PizzaDto.builder()
                .id(pizza.getId())
                .name(pizza.getName())
                .price(pizza.getPrice())
                .build();
    }
}
