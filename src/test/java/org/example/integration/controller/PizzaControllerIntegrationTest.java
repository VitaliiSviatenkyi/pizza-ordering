package org.example.integration.controller;

import org.example.model.Pizza;
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
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PizzaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PizzaRepository pizzaRepository;

    @BeforeAll
    void setupAll() {
        pizzaRepository.deleteAll();
    }

    //given
    @BeforeEach
    void setup() {
        Pizza pizza1 = Pizza.builder().name("Pepperoni").price(BigDecimal.valueOf(122)).build();
        Pizza pizza2 = Pizza.builder().name("Margherita").price(BigDecimal.valueOf(133.99)).build();
        Pizza pizza3 = Pizza.builder().name("BBG").price(BigDecimal.valueOf(241)).build();
        pizzaRepository.saveAll(List.of(pizza1, pizza2, pizza3));
    }

    @AfterEach
    void cleanup() {
        pizzaRepository.deleteAll();
    }

    @Test
    void shouldReturnAllPizza() throws Exception {
        //when
        mockMvc.perform(get("/api/pizzas")
                        .contentType(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].name").value("Pepperoni"))
                .andExpect(jsonPath("$[1].name").value("Margherita"))
                .andExpect(jsonPath("$[2].name").value("BBG"))
                .andExpect(jsonPath("$[0].price").value(122))
                .andExpect(jsonPath("$[1].price").value(133.99))
                .andExpect(jsonPath("$[2].price").value(241));
    }
}
