package com.auto.demo.service;

import java.util.List;

import com.auto.demo.DTO.CompraDTO;

public interface CompraService {

    public CompraDTO createCompra(CompraDTO compraDTO) throws Exception;

    public List<CompraDTO> getCompraForCliente(Integer id) throws Exception;
}
