package com.auto.demo.service;

import java.util.List;

import com.auto.demo.DTO.AutoAdminDTO;
import com.auto.demo.DTO.AutoClienteDTO;

public interface AutoService {
    
    //administrador
    public List<AutoAdminDTO> getAllAutosForAdmin(Integer id) throws Exception;

    public AutoAdminDTO createAuto(AutoAdminDTO autoCreate) throws Exception;

    //clientes

    public List<AutoClienteDTO> getAllAutosForCliente() throws Exception;

    
}
