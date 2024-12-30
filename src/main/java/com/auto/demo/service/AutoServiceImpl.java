package com.auto.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.auto.demo.DTO.AutoAdminDTO;
import com.auto.demo.DTO.AutoClienteDTO;
import com.auto.demo.mapper.AutoMapper;
import com.auto.demo.model.Auto;
import com.auto.demo.repository.AutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {

    private final AutoRepository autoRepository;
    private final AutoMapper autoMapper;

    @Override
    public List<AutoAdminDTO> getAllAutosForAdmin(Integer id) throws Exception {
        try {
            List<Auto> autos = autoRepository.findByAdministradorId(id);
            return autos.stream()
                    .map(AutoMapper::toAutoAdminDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error fetching autos: " + e.getMessage());
        }
    }

    @Override
    public AutoAdminDTO getAutoById(Integer id) throws Exception {
        Optional<Auto> OptionalAuto = autoRepository.findById(id);
        if (OptionalAuto.isPresent()) {
            return AutoMapper.toAutoAdminDTO(OptionalAuto.get());
        } else {
            throw new Exception("Auto not found with id: " + id);
        }
    }

    @Override
    public AutoAdminDTO createAuto(AutoAdminDTO autoCreate) throws Exception {
        Auto auto = autoMapper.toEntity(autoCreate);
        Auto savedAuto = autoRepository.save(auto);
        return AutoMapper.toAutoAdminDTO(savedAuto);
    }

    @Override
    public List<AutoClienteDTO> getAllAutosForCliente() throws Exception {
        try {
            List<Auto> autos = autoRepository.findAll();
            return autos.stream()
                    .map(AutoMapper::toAutoClienteDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Error fetching autos: " + e.getMessage());
        }
    }

    @Override
    public void deleteAuto(Integer id) throws Exception {
        if (!autoRepository.existsById(id)) {
            throw new Exception("El auto no existe");
        }
        autoRepository.deleteById(id);
    }

}