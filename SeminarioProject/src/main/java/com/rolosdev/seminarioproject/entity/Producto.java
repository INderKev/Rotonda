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
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @Column(name = "IDPRODUCTO", nullable = false)
    private int idProducto;

    @Column(name = "NOM_PRODUCTO", nullable = false)
    private String nombre;

    @Column(name = "PRECIO_PRODUCTO", nullable = false)
    private double precio;

    @Column(name = "IMAGEN_PRODUCTO", nullable = false)
    private String imagenProducto;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Restaurante.class)
    @JoinColumn(name = "IDRESTAURANTE", nullable = false)
    private Restaurante restaurante;
    
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Clasificacion.class)
    @JoinColumn(name = "IDCLASIFICACION", nullable = false)
    private Clasificacion clasificacion;

}
