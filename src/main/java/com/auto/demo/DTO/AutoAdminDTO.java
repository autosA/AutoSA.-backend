package com.auto.demo.DTO;

import lombok.Data;

@Data
public class AutoAdminDTO {

    private Integer id;
    private String brand;
    private String model;
    private Double price;
    private String year;
    private String description;
    private Boolean available;
    private Integer administradorId;
    
}
