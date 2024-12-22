package com.auto.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.demo.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    List<Compra> findByAutoId(Integer autoId);

    List<Compra> findByClienteId(Integer clienteId);
}
