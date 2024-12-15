package org.example.service.impl;

import org.example.AbstractUnitTest;
import org.example.model.Pizza;
import org.example.repository.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PizzaServiceImplUnitTest extends AbstractUnitTest {

    @Mock
    private PizzaRepository pizzaRepositoryMock;

    @InjectMocks
    private PizzaServiceImpl sut;

    @Test
    void findAllPizzaAndReturnInList() {
        //given
        List<Pizza> expectedList = List.of(pizza, pizza);
        when(pizzaRepositoryMock.findAll()).thenReturn(expectedList);
        //when
        List<Pizza> actualList = sut.findAll();
        //then
        assertEquals(expectedList, actualList);
    }
}