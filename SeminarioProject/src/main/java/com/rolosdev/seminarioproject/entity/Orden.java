package com.rolosdev.seminarioproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDEN")
public class Orden {

    @Id
    @Column(name = "IDORDEN", nullable = false)
    private int idOrden;
    @Column(name = "IDCOMPRA", nullable = false)
    private int idCompra;
    @Column(name = "IDMENU_SELECCIONADO", nullable = true)
    private Integer idMenuSeleccionado;
    @Column(name = "IDPRODUCTO", nullable = true)
    private Integer idProducto;
    @Column(name = "OBSERVACIONES", nullable = false)
    private String observaciones;

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdMenuSeleccionado() {
        return idMenuSeleccionado;
    }

    public void setIdMenuSeleccionado(int idMenuSeleccionado) {
        this.idMenuSeleccionado = idMenuSeleccionado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
