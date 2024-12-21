package com.auto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.demo.model.Administrador;

@Repository
public interface AdministradorRepository  extends JpaRepository< Administrador, Integer>{
    
}
