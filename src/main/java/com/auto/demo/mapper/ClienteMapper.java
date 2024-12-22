package com.auto.demo.mapper;

import com.auto.demo.DTO.ClienteDTO;
import com.auto.demo.model.Cliente;

public class ClienteMapper {
    
    public static ClienteDTO toClienteDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setName(cliente.getName());
        clienteDTO.setUsername(cliente.getUsername());
        clienteDTO.setPassword(cliente.getPassword());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setTelephone(cliente.getTelephone());
        clienteDTO.setCompanyName(cliente.getCompanyName());
        clienteDTO.setCity(cliente.getCity());
        clienteDTO.setAddress(cliente.getAddress());
        return clienteDTO;
    }

    public static Cliente toEntity(ClienteDTO clienteDTO){

        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setName(clienteDTO.getName());
        cliente.setUsername(clienteDTO.getUsername());
        cliente.setPassword(clienteDTO.getPassword());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelephone(clienteDTO.getTelephone());
        cliente.setCompanyName(clienteDTO.getCompanyName());
        cliente.setCity(clienteDTO.getCity());
        cliente.setAddress(clienteDTO.getAddress());
        return cliente;
        
    }
}
