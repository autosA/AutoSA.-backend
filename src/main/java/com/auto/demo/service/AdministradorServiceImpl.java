package com.auto.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.auto.demo.DTO.AdministradorDTO;
import com.auto.demo.mapper.AdministradorMapper;
import com.auto.demo.model.Administrador;
import com.auto.demo.repository.AdministradorRepository;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public List<AdministradorDTO> getAllAdmins() throws Exception {
        try {
            List<Administrador> administradores = administradorRepository.findAll();
            return administradores.stream().map(AdministradorMapper::toAdminDTO).collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new Exception("Error fetching admins: " + e.getMessage());
        }
    }

    @Override
    public AdministradorDTO getAdminById(Integer id) throws Exception {
        Optional<Administrador> optionalAdmin = administradorRepository.findById(id);
        if (optionalAdmin.isPresent()) {
            return AdministradorMapper.toAdminDTO(optionalAdmin.get());
        } else {
            throw new Exception("Admin not found with id: " + id);
        }
    }

    @Override
    public AdministradorDTO createAdmin(AdministradorDTO administradorDTO) throws Exception {
        try {
            Administrador administrador = AdministradorMapper.toEntity(administradorDTO);
            administrador = administradorRepository.save(administrador);
            return AdministradorMapper.toAdminDTO(administrador);
        } catch (DataAccessException e) {
            throw new Exception("Error creating admin: " + e.getMessage());

        }
    }
}
