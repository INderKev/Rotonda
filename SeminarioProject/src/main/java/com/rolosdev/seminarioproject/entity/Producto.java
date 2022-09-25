package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @Column(name = "IDPRODUCTO", nullable = false)
    private int idProducto;
    @Column(name = "IDRESTAURANTE", nullable = false)
    private int idRestaurante;
    @Column(name = "IDCLASIFICACION", nullable = false)
    private int idClasificacion;
    @Column(name = "NOM_PRODUCTO", nullable = false)
    private String nombre;
    @Column(name = "PRECIO_PRODUCTO", nullable = false)
    private String precio;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
