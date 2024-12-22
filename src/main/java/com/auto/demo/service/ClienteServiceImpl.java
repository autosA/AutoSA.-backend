package com.auto.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.auto.demo.DTO.ClienteDTO;
import com.auto.demo.mapper.ClienteMapper;
import com.auto.demo.model.Cliente;
import com.auto.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getAllClientes() throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAll();
            return clientes.stream()
                    .map(ClienteMapper::toClienteDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error fetching clientes: " + e.getMessage());
        }
    }

    @Override
    public ClienteDTO getClienteById(Integer id) throws Exception {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            return ClienteMapper.toClienteDTO(optionalCliente.get());
        } else {
            throw new Exception("Cliente not found with id: " + id);
        }
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO createCliente) throws Exception {
        try {
            Cliente cliente = ClienteMapper.toEntity(createCliente);
            cliente = clienteRepository.save(cliente);
            return ClienteMapper.toClienteDTO(cliente);
        } catch (DataAccessException e) {
            throw new Exception("Error creating cliente: " + e.getMessage());


        }
    }

    @Override
    public ClienteDTO updateCliente(ClienteDTO updateCliente) throws Exception {
        try {
            Optional<Cliente> optionalCliente = clienteRepository.findById(updateCliente.getId());
            if (optionalCliente.isPresent()) {
                Cliente clienteToUpdate = optionalCliente.get();
                clienteToUpdate.setName(updateCliente.getName());
                clienteToUpdate.setUsername(updateCliente.getUsername());
                clienteToUpdate.setPassword(updateCliente.getPassword());
                clienteToUpdate.setEmail(updateCliente.getEmail());
                clienteToUpdate.setTelephone(updateCliente.getTelephone());
                clienteToUpdate.setCompanyName(updateCliente.getCompanyName());
                clienteToUpdate.setCity(updateCliente.getCity());
                clienteToUpdate.setAddress(updateCliente.getAddress());

                clienteToUpdate = clienteRepository.save(clienteToUpdate);
                return ClienteMapper.toClienteDTO(clienteToUpdate);
            } else {
                throw new Exception("Cliente not found with id: " + updateCliente.getId());

            }
        } catch (Exception e) {
            throw new Exception("Error updating Cliente: " + e.getMessage());
        }
    }

    @Override
    public void deleteCliente(Integer id) throws Exception {
        if (!clienteRepository.existsById(id)) {
            throw new Exception("La encuesta no existe");
        }
        clienteRepository.deleteById(id);
    }

}
