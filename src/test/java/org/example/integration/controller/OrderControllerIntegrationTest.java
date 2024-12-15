package org.example.integration.controller;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.PizzaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @BeforeAll
    void setupAll() {
        orderRepository.deleteAll();
        customerRepository.deleteAll();
        pizzaRepository.deleteAll();
    }

    //given
    @BeforeEach
    void setup() {
        Customer customer = Customer.builder().name("Ricardo").address("Spain").build();
        customerRepository.save(customer);

        Pizza pizza1 = Pizza.builder().name("Pepperoni").price(BigDecimal.valueOf(122)).build();
        Pizza pizza2 = Pizza.builder().name("Margherita").price(BigDecimal.valueOf(133.99)).build();
        pizzaRepository.saveAll(List.of(pizza1, pizza2));

        Order order = Order.builder().customer(customer).pizzaList(List.of(pizza1, pizza2))
                .creationDate(LocalDateTime
                        .of(2023, 12, 13, 10, 30, 0))
                .build();
        orderRepository.save(order);
    }

    @AfterEach
    void cleanup() {
        orderRepository.deleteAll();
    }

    @Test
    void shouldReturnAllOrder() throws Exception {
        //when
        mockMvc.perform(get("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()").value(1))

                .andExpect(jsonPath("$[0].customerDto.name").value("Ricardo"))
                .andExpect(jsonPath("$[0].customerDto.address").value("Spain"))

                .andExpect(jsonPath("$[0].pizzaDtoList[0].name").value("Pepperoni"))
                .andExpect(jsonPath("$[0].pizzaDtoList[1].name").value("Margherita"))

                .andExpect(jsonPath("$[0].pizzaDtoList[0].price").value(122.00))
                .andExpect(jsonPath("$[0].pizzaDtoList[1].price").value(133.99))

                .andExpect(jsonPath("$[0].creationDate").value("2023-12-13T10:30:00"));

    }
}