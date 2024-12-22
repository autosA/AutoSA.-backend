package com.auto.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.demo.DTO.CompraDTO;
import com.auto.demo.service.CompraService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/api/compras")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @GetMapping("cliente/{clienteId}")
    public ResponseEntity<List<CompraDTO>> getCompraForCliente(@PathVariable("clienteId") Integer id) {
        try {
            return ResponseEntity.ok(compraService.getCompraForCliente(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CompraDTO> createCompra(@RequestBody CompraDTO compraDTO) {
        try {
            return ResponseEntity.ok(compraService.createCompra(compraDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
