package com.auto.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.demo.DTO.ClienteDTO;
import com.auto.demo.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/api/clientes")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        try {
            return ResponseEntity.ok(clienteService.getAllClientes());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable("clienteId") Integer id) {
        try {
            return ResponseEntity.ok(clienteService.getClienteById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            return ResponseEntity.ok(clienteService.createCliente(clienteDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable("clienteId") Integer id, @RequestBody ClienteDTO clienteDTO) {
        try {
            clienteDTO.setId(id);
            return ResponseEntity.ok(clienteService.updateCliente(clienteDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
