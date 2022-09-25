package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASIFICACION")
public class Clasificacion {

    @Id
    @Column(name = "IDCLASIFICACION", nullable = false)
    private int idClasificacion;
    @Column(name = "NOM_CLASIFICACION", nullable = false)
    private int nombreClasificacion;

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getNombreClasificacion() {
        return nombreClasificacion;
    }

    public void setNombreClasificacion(int nombreClasificacion) {
        this.nombreClasificacion = nombreClasificacion;
    }
}
