package com.auto.demo.mapper;

import org.springframework.stereotype.Component;

import com.auto.demo.DTO.AutoAdminDTO;
import com.auto.demo.DTO.AutoClienteDTO;
import com.auto.demo.model.Administrador;
import com.auto.demo.model.Auto;
import com.auto.demo.repository.AdministradorRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AutoMapper {

    private final AdministradorRepository administradorRepository;

    public AutoAdminDTO toAutoAdminDTO(Auto auto) {

        if (auto == null) {
            return null;
        }

        AutoAdminDTO autoAdminDTO = new AutoAdminDTO();
        autoAdminDTO.setId(auto.getId());
        autoAdminDTO.setBrand(auto.getBrand());
        autoAdminDTO.setModel(auto.getModel());
        autoAdminDTO.setCategory(auto.getCategory());
        autoAdminDTO.setPrice(auto.getPrice());
        autoAdminDTO.setYear(auto.getYear());
        autoAdminDTO.setDescription(auto.getDescription());
        autoAdminDTO.setAvailable(auto.getAvailable());
        autoAdminDTO.setImg(auto.getImg());
        if (auto.getAdministrador() != null) {
            autoAdminDTO.setAdministradorId(auto.getAdministrador().getId());
        }
        return autoAdminDTO;
    }

    public AutoClienteDTO toAutoClienteDTO(Auto auto) {
        if (auto == null) {
            return null;
        }
        AutoClienteDTO autoClienteDTO = new AutoClienteDTO();
        autoClienteDTO.setId(auto.getId());
        autoClienteDTO.setBrand(auto.getBrand());
        autoClienteDTO.setModel(auto.getModel());
        autoClienteDTO.setCategory(auto.getCategory());
        autoClienteDTO.setPrice(auto.getPrice());
        autoClienteDTO.setYear(auto.getYear());
        autoClienteDTO.setDescription(auto.getDescription());
        autoClienteDTO.setAvailable(auto.getAvailable());
        autoClienteDTO.setImg(auto.getImg());
        return autoClienteDTO;
    }

    public Auto toEntity(AutoAdminDTO autoAadminDTO) throws Exception {
        if (autoAadminDTO == null) {
            return null;
        }
        Auto auto = new Auto();
        auto.setId(autoAadminDTO.getId());
        auto.setBrand(autoAadminDTO.getBrand());
        auto.setModel(autoAadminDTO.getModel());
        auto.setCategory(autoAadminDTO.getCategory());
        auto.setPrice(autoAadminDTO.getPrice());
        auto.setYear(autoAadminDTO.getYear());
        auto.setDescription(autoAadminDTO.getDescription());
        auto.setAvailable(autoAadminDTO.getAvailable());
        auto.setImg(autoAadminDTO.getImg());

        Administrador administrador = administradorRepository.findById(autoAadminDTO.getAdministradorId())
                .orElseThrow(() -> new Exception("Admin not found with ID: " + autoAadminDTO.getAdministradorId()));
        auto.setAdministrador(administrador);

        return auto;
    }

}
