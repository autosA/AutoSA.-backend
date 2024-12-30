package com.auto.demo.service;

import java.util.List;

import com.auto.demo.DTO.AutoAdminDTO;
import com.auto.demo.DTO.AutoClienteDTO;

public interface AutoService {
    
    public List<AutoAdminDTO> getAllAutosForAdmin(Integer id) throws Exception;

    public AutoAdminDTO createAuto(AutoAdminDTO autoCreate) throws Exception;

    public void deleteAuto(Integer id) throws Exception;

    public List<AutoClienteDTO> getAllAutosForCliente() throws Exception;

    public AutoAdminDTO getAutoById(Integer id) throws Exception;

    public List<AutoAdminDTO> getAutoByCategory(String category) throws  Exception;
}
