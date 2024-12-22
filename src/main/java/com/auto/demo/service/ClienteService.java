package com.auto.demo.service;

import java.util.List;

import com.auto.demo.DTO.ClienteDTO;

public interface ClienteService {

    public List<ClienteDTO> getAllClientes() throws Exception;

    public ClienteDTO getClienteById(Integer id) throws Exception;

    public ClienteDTO createCliente(ClienteDTO createCliente) throws Exception;

    public ClienteDTO updateCliente(ClienteDTO updateCliente) throws Exception;

    public void deleteCliente(Integer id) throws Exception;
}
