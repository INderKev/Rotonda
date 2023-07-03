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
@Table(name = "PRODUCTO_INGREDIENTE")
public class ProductoIngrediente {

    @Id
    @Column(name = "IDPRODUCTOINGREDIENTE", nullable = false)
    private int idProductoIngrediente;

    @Column(name = "CANTIDAD", nullable = false)
    private double cantidad;

    @Column(name = "EDITABLE", nullable = false)
    private boolean editable;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Ingrediente.class)
    @JoinColumn(name = "IDINGREDIENTE", nullable = false)
    private Ingrediente ingrediente;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Producto.class)
    @JoinColumn(name = "IDPRODUCTO", nullable = false)
    private Producto producto;

}
