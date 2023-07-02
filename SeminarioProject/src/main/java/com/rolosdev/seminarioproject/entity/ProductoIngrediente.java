package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCTO_INGREDIENTE")
public class ProductoIngrediente {

    @Id
    @Column(name = "IDPRODUCTOINGREDIENTE", nullable = false)
    private int idProductoIngrediente;
    @Column(name = "IDINGREDIENTE", nullable = false)
    private int idIngrediente;
    @Column(name = "IDPRODUCTO", nullable = false)
    private int idProducto;
    @Column(name = "CANTIDAD", nullable = false)
    private double cantidad;
    @Column(name = "EDITABLE", nullable = false)
    private boolean editable;

}
