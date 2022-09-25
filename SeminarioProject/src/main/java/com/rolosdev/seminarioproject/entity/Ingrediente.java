package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENTE")
public class Ingrediente {

    @Id
    @Column(name = "IDINGREDIENTE", nullable = false)
    private int idIngrediente;
    @Column(name = "NOM_INGREDIENTE", nullable = false)
    private String nombre;
    @Column(name = "TIPO_UNIDAD", nullable = false)
    private String tipoUnidad;

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }
}
