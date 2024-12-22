package com.auto.demo.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CompraDTO {
    
    private Integer id;
    private LocalDate date;
    private Double montoNeto;
    private Integer autoId;
    private Integer clienteId;

}
