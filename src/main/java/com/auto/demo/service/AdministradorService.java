package com.auto.demo.service;

import java.util.List;

import com.auto.demo.DTO.AdministradorDTO;

public interface AdministradorService {

    public List<AdministradorDTO> getAllAdmins() throws Exception;

    public AdministradorDTO getAdminById(Integer id) throws Exception;

    public AdministradorDTO createAdmin(AdministradorDTO administradorDTO) throws Exception;

}
