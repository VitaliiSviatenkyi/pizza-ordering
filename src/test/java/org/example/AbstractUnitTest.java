package org.example;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.Pizza;
import org.example.web.dto.CustomerDto;
import org.example.web.dto.OrderDto;
import org.example.web.dto.PizzaDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public abstract class AbstractUnitTest {

    protected Integer id = 1;
    protected String name = "Some name";
    protected String address = "Some address";
    protected BigDecimal price = BigDecimal.valueOf(155);
    protected LocalDateTime creationDate = LocalDateTime
            .of(2023, 12, 13, 10, 30, 0);

    protected Customer customer = Customer.builder().id(id).name(name).address(address).build();
    protected CustomerDto customerDto = CustomerDto.builder().id(id).name(name).address(address).build();

    protected Pizza pizza = Pizza.builder().id(id).name(name).price(price).build();
    protected PizzaDto pizzaDto = PizzaDto.builder().id(id).name(name).price(price).build();

    protected Order order = Order.builder()
            .customer(customer).pizzaList(List.of(pizza)).creationDate(creationDate).build();
    protected OrderDto orderDto = OrderDto.builder()
            .customerDto(customerDto).pizzaDtoList(List.of(pizzaDto)).creationDate(creationDate).build();
}
