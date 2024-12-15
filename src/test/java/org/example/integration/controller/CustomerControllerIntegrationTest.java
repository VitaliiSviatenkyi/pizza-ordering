package org.example.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.example.web.dto.CreateCustomerDto;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeAll
    void setupAll() {
        customerRepository.deleteAll();

    }

    //given
    @BeforeEach
    void setup() {
        Customer customer1 = Customer.builder().name("Alex").address("Prague").build();
        Customer customer2 = Customer.builder().name("Ben").address("London").build();
        customerRepository.saveAll(List.of(customer1, customer2));
    }

    @AfterEach
    void cleanup() {
        customerRepository.deleteAll();
    }

    @Test
    void shouldReturnAllCustomer() throws Exception {
        //when
        mockMvc.perform(get("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Alex"))
                .andExpect(jsonPath("$[1].name").value("Ben"))
                .andExpect(jsonPath("$[0].address").value("Prague"))
                .andExpect(jsonPath("$[1].address").value("London"));
    }

    @Test
    void shouldCreateCustomer() throws Exception {
        //given
        CreateCustomerDto createCustomerDto = new CreateCustomerDto("Canon", "New York");

        //when
        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createCustomerDto)))
                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Canon"))
                .andExpect(jsonPath("$.address").value("New York"));
    }

}
