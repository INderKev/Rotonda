package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CLASIFICACION")
public class Clasificacion {

    @Id
    @Column(name = "IDCLASIFICACION", nullable = false)
    private int idClasificacion;

    @Column(name = "NOM_CLASIFICACION", nullable = false)
    private String nombreClasificacion;

}
