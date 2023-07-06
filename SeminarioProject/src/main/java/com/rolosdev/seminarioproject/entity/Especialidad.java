package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ESPECIALIDAD")
public class Especialidad {

    @Id
    @Column(name = "IDESPECIALIDAD", nullable = false)
    private int idEspecialidad;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}
