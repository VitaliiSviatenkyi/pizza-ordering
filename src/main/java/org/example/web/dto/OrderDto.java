package org.example.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer id;
    private CustomerDto customerDto;
    private List<PizzaDto> pizzaDtoList;
    private LocalDateTime creationDate;


}
