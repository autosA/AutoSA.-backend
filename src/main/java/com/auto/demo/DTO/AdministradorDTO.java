package com.auto.demo.DTO;

import java.util.Set;

import lombok.Data;

@Data
public class AdministradorDTO {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Set<AutoClienteDTO> autos;
}
