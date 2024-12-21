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

import com.auto.demo.DTO.AdministradorDTO;
import com.auto.demo.service.AdministradorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/api/admins")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<AdministradorDTO>> getAllAdmins() {
        try {
            return ResponseEntity.ok(administradorService.getAllAdmins());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdministradorDTO> getAdminById(@PathVariable("adminId") Integer id) {
        try {
            return ResponseEntity.ok(administradorService.getAdminById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AdministradorDTO> createAdmin (@RequestBody AdministradorDTO administradorDTO) { 
        try {
            return ResponseEntity.ok(administradorService.createAdmin(administradorDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
