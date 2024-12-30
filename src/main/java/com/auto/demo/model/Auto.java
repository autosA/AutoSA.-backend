package com.auto.demo.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table( name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "marca", nullable = false, length = 50)
    private String brand;

    @Column(name = "modelo", nullable = false, length = 50)
    private String model;

    @Column(name = "categoria", nullable = false, length = 50)
    private String category;

    @Column(name = "precio", nullable = false)
    private Double price;

    @Column( name = "año")
    private String year;

    @Column(name = "descripcion", nullable = false, length = 120)
    private String description;

    @Column(name = "disponibilidad", nullable = false)
    private Boolean available;

    @Column(name = "img", nullable = false, length = 2083)
    private String img;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    private Set<Compra> compras;

    @ManyToOne
    @JoinColumn(name = "administrador_id", nullable = false)
    private Administrador administrador;

}
