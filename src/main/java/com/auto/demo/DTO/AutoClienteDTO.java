package com.auto.demo.DTO;

import lombok.Data;

@Data
public class AutoClienteDTO {

    private Integer id;
    private String brand;
    private String model;
    private Double price;
    private String year;
    private String description;
    private Double available;

}
