package org.example.web.controller;

import org.example.AbstractUnitTest;
import org.example.facade.PizzaFacade;
import org.example.web.dto.PizzaDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaControllerUnitTest extends AbstractUnitTest {

    @Mock
    private PizzaFacade pizzaFacadeMock;

    @InjectMocks
    private PizzaController sut;

    @Test
    void findAllPizzaDtoAndReturnInList() {
        //given
        List<PizzaDto> expectedList = List.of(pizzaDto);
        when(pizzaFacadeMock.findAll()).thenReturn(expectedList);

        //when
        List<PizzaDto> actualList = sut.findAll();

        //then
        assertEquals(expectedList, actualList);
    }
}