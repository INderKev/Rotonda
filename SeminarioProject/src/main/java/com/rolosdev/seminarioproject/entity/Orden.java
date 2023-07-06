package com.rolosdev.seminarioproject.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "ORDEN")
public class Orden {

    @Id
    @Column(name = "IDORDEN", nullable = false)
    private int idOrden;

    @Column(name = "OBSERVACIONES", nullable = false)
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Compra.class)
    @JoinColumn(name = "IDCOMPRA", nullable = false)
    private Compra compra;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MenuSeleccionado.class)
    @JoinColumn(name = "IDMENU_SELECCIONADO", nullable = true)
    private MenuSeleccionado menuSeleccionado;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Producto.class)
    @JoinColumn(name = "IDPRODUCTO", nullable = true)
    private Producto producto;

}
