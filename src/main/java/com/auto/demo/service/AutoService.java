package com.auto.demo.service;

import java.util.List;

import com.auto.demo.DTO.AutoAdminDTO;

public interface AutoService {
    
    //administrador
    public List<AutoAdminDTO> getAllAutosForAdmin(Integer id) throws Exception;

    public AutoAdminDTO createAuto(AutoAdminDTO autoCreate) throws Exception;

    //clientes
    
}
