package com.rolosdev.seminarioproject.entity;

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
    @Column(name = "IDMENU", nullable = true)
    private int idMenu;
    @Column(name = "IDMENU_SELECCIONADO", nullable = true)
    private int idMenuSeleccionado;
    @Column(name = "IDCLASIFICACION", nullable = false)
    private int idClasificacion;
    @Column(name = "IDPRODUCTO", nullable = true)
    private int idProductivo;
    @Column(name = "PRECIO_BAJO", nullable = false)
    private double precioBajo;
    @Column(name = "PRECIO_ALTO", nullable = false)
    private double precioAlto;

    public int getIdSeleccion() {
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

    public void setIdMenuSeleccionado(int menIdMenu) {
        this.idMenuSeleccionado = menIdMenu;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getIdProductivo() {
        return idProductivo;
    }

    public void setIdProductivo(int idProductivo) {
        this.idProductivo = idProductivo;
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
