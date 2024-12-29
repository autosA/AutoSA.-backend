package com.auto.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.demo.DTO.AutoAdminDTO;
import com.auto.demo.DTO.AutoClienteDTO;
import com.auto.demo.service.AutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/api/autos")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class AutoController {

    private final AutoService autoService;

    @GetMapping("admin/{adminId}")
    public ResponseEntity<List<AutoAdminDTO>> getAutosForAdmin(@PathVariable("adminId") Integer id) {
        try {
            return ResponseEntity.ok(autoService.getAllAutosForAdmin(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<AutoClienteDTO>> getAllAutos() {
        try {
            return ResponseEntity.ok(autoService.getAllAutosForCliente());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<AutoAdminDTO> createAuto(@RequestBody AutoAdminDTO adminDTO) {
        try {
            return ResponseEntity.ok(autoService.createAuto(adminDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{autoId}")
    public ResponseEntity<Void> deleteAuto(@PathVariable("autoId") Integer id){
        try {
            autoService.deleteAuto(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
