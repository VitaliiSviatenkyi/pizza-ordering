package org.example.facade.impl;

import org.example.AbstractUnitTest;
import org.example.model.Pizza;
import org.example.service.PizzaService;
import org.example.web.dto.PizzaDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaFacadeImplUnitTest extends AbstractUnitTest {

    @Mock
    private PizzaService pizzaServiceMock;
    @Mock
    private ConversionService conversionServiceMock;
    @InjectMocks
    private PizzaFacadeImpl sut;

    @Test
    void findAllPizzaDtoAndReturnInList() {
        //given
        Pizza expected = pizza;
        PizzaDto expectedDto = pizzaDto;
        List<Pizza> expectedList = List.of(expected, expected);
        List<PizzaDto> expectedDtoList = List.of(expectedDto, expectedDto);
        when(pizzaServiceMock.findAll()).thenReturn(expectedList);
        when(conversionServiceMock.convert(expected, PizzaDto.class)).thenReturn(expectedDto);
        //when
        List<PizzaDto> actualDtoList = sut.findAll();
        //then
        assertEquals(expectedDtoList, actualDtoList);
    }
}