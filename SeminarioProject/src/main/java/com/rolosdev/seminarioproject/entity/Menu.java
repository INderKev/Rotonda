package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "MENU")
public class Menu {

    @Id
    @Column(name = "IDMENU", nullable = false)
    private int idMenu;

    @Column(name = "NOM_MENU", nullable = false)
    private String nombre;

    @Column(name = "PRECIO", nullable = false)
    private double precio;

    @Column(name = "IMAGEN_MENU", nullable = false)
    private String imagenMenu;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Restaurante.class)
    @JoinColumn(name = "IDRESTAURANTE", nullable = false)
    private Restaurante restaurante;

}
