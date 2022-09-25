package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

    public int getIdProductoIngrediente() {
        return idProductoIngrediente;
    }

    public void setIdProductoIngrediente(int idProductoIngrediente) {
        this.idProductoIngrediente = idProductoIngrediente;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
