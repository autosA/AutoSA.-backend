package com.auto.demo.mapper;

import com.auto.demo.DTO.AdministradorDTO;
import com.auto.demo.model.Administrador;

public class AdministradorMapper {
    
    public static AdministradorDTO toAdminDTO (Administrador administrador){
        AdministradorDTO administradorDTO = new AdministradorDTO();
        administradorDTO.setId(administrador.getId());
        administradorDTO.setName(administrador.getName());
        administradorDTO.setUsername(administrador.getUsername());
        administradorDTO.setPassword(administrador.getPassword());
        administradorDTO.setEmail(administrador.getEmail());
        return administradorDTO;
    }

    public static Administrador toEntity (AdministradorDTO administradorDTO){
        Administrador administrador = new Administrador();
        administrador.setId(administradorDTO.getId());
        administrador.setName(administradorDTO.getName());
        administrador.setUsername(administradorDTO.getUsername());
        administrador.setPassword(administradorDTO.getPassword());
        administrador.setEmail(administradorDTO.getEmail());
        return administrador;
    }
}
