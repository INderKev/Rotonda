package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "INGREDIENTE")
public class Ingrediente {

    @Id
    @Column(name = "IDINGREDIENTE", nullable = false)
    private int idIngrediente;
    @Column(name = "NOM_INGREDIENTE", nullable = false)
    private String nombre;
    @Column(name = "TIPO_UNIDAD", nullable = false)
    private String tipoUnidad;
    @Column(name = "DESCRIPCION", nullable = true)
    private String descripcion;

}
