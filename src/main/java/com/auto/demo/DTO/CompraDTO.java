package com.auto.demo.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class CompraDTO {
    
    private Integer id;
    private Date date;
    private Double montoNeto;
    private Integer autoId;
    private Integer clienteId;

}
