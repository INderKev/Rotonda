package com.rolosdev.seminarioproject.entity;

import org.springframework.lang.Nullable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "SELECCION")
public class Seleccion {

    @Id
    @Column(name = "IDSELECCION", nullable = false)
    private int idSeleccion;

    @Column(name = "PRECIO_BAJO")
    private Double precioBajo;

    @Column(name = "PRECIO_ALTO")
    private Double precioAlto;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Menu.class)
    @JoinColumn(name = "IDMENU", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Producto.class)
    @JoinColumn(name = "IDPRODUCTO")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MenuSeleccionado.class)
    @Nullable
    @JoinColumn(name = "IDMENU_SELECCIONADO")
    private MenuSeleccionado menuSeleccionado;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Clasificacion.class)
    @JoinColumn(name = "IDCLASIFICACION", nullable = false)
    private Clasificacion clasificacion;

}
