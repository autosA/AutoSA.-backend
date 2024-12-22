package com.auto.demo.mapper;

import org.springframework.stereotype.Component;

import com.auto.demo.DTO.CompraDTO;
import com.auto.demo.model.Auto;
import com.auto.demo.model.Cliente;
import com.auto.demo.model.Compra;
import com.auto.demo.repository.AutoRepository;
import com.auto.demo.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CompraMapper {

    private final AutoRepository autoRepository;

    private final ClienteRepository clienteRepository;

    public CompraDTO toCompraDTO(Compra compra) {
        if (compra == null) {
            return null;
        }
        CompraDTO compraDTO = new CompraDTO();
        compraDTO.setId(compra.getId());
        compraDTO.setDate(compra.getDate());
        compraDTO.setMontoNeto(compra.getMontoNeto());
        compraDTO.setAutoId(compra.getAuto().getId());
        compraDTO.setClienteId(compra.getCliente().getId());
        return compraDTO;
    }

    public Compra toEntity(CompraDTO compraDTO) throws Exception {
        if (compraDTO == null) {
            return null;
        }

        Compra compra = new Compra();
        compra.setId(compraDTO.getId());
        compra.setDate(compraDTO.getDate());
        compra.setMontoNeto(compraDTO.getMontoNeto());

        Auto auto = autoRepository.findById(compraDTO.getAutoId())
        .orElseThrow(() -> new Exception("Auto not found with ID: " + compraDTO.getAutoId()));
        compra.setAuto(auto);

        Cliente cliente = clienteRepository.findById(compraDTO.getClienteId())
        .orElseThrow(() -> new Exception("Cliente not found with ID: " + compraDTO.getClienteId()));
        compra.setCliente(cliente);

        return compra;
    }
}
