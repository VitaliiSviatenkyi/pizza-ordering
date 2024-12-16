package org.example.service.impl;

import org.example.AbstractUnitTest;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplUnitTest extends AbstractUnitTest {

    @Mock
    private CustomerRepository customerRepositoryMock;

    @Mock
    private PizzaRepository pizzaRepositoryMock;

    @Mock
    private OrderRepository orderRepositoryMock;

    @InjectMocks
    private OrderServiceImpl sut;

    @Test
    void saveAndReturnOrder() {
        //given
        Order expected = order;
        try (MockedStatic<LocalDateTime> mockedDateTime = mockStatic(LocalDateTime.class)) {
            mockedDateTime.when(LocalDateTime::now).thenReturn(expected.getCreationDate());

            when(customerRepositoryMock.findById(expected.getCustomer().getId()))
                    .thenReturn(Optional.ofNullable(expected.getCustomer()));

            for (Pizza pizza : expected.getPizzaList()) {
                when(pizzaRepositoryMock.findById(pizza.getId()))
                        .thenReturn(Optional.of(pizza));
            }
            when(orderRepositoryMock.save(expected)).thenReturn(expected);
            //when
            Order actual = sut.save(expected.getCustomer().getId(),
                    expected.getPizzaList().stream().map(Pizza::getId).collect(Collectors.toList()));
            //then
            assertEquals(expected, actual);
        }
    }
}