package com.auto.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.demo.model.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
    List<Auto> findByAdministradorId(Integer administradorId);
    List<Auto> findByCategory(String category);
}
