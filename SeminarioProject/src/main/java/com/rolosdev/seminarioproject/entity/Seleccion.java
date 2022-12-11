package com.rolosdev.seminarioproject.entity;

import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SELECCION")
public class Seleccion {

    @Id
    @Column(name = "IDSELECCION", nullable = false)
    private int idSeleccion;
    @Column(name = "IDMENU")
    private Integer idMenu;
    @Nullable
    @Column(name = "IDMENU_SELECCIONADO")
    private Integer idMenuSeleccionado;
    @Column(name = "IDCLASIFICACION", nullable = false)
    private int idClasificacion;
    @Column(name = "IDPRODUCTO")
    private Integer idProducto;
    @Column(name = "PRECIO_BAJO")
    private Double precioBajo;
    @Column(name = "PRECIO_ALTO")
    private Double precioAlto;

    public Integer getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdMenuSeleccionado() {
        return idMenuSeleccionado;
    }

    public void setIdMenuSeleccionado(int idMenuSeleccionado) {
        this.idMenuSeleccionado = idMenuSeleccionado;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioBajo() {
        return precioBajo;
    }

    public void setPrecioBajo(double precioBajo) {
        this.precioBajo = precioBajo;
    }

    public double getPrecioAlto() {
        return precioAlto;
    }

    public void setPrecioAlto(double precioAlto) {
        this.precioAlto = precioAlto;
    }
}
