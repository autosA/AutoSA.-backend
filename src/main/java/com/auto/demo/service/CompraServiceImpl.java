package com.auto.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.auto.demo.DTO.CompraDTO;
import com.auto.demo.mapper.CompraMapper;
import com.auto.demo.model.Compra;
import com.auto.demo.repository.CompraRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final CompraMapper compraMapper;

    @Override
    public CompraDTO createCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = compraMapper.toEntity(compraDTO);
        Compra savedCompra = compraRepository.save(compra);
        return compraMapper.toCompraDTO(savedCompra);
    }

    @Override
    public List<CompraDTO> getCompraForCliente(Integer id) throws Exception {
        try {
            List<Compra> compras = compraRepository.findByClienteId(id);
            return compras.stream()
                    .map(compraMapper::toCompraDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error fetching compra: " + e.getMessage());
        }
    }
}
