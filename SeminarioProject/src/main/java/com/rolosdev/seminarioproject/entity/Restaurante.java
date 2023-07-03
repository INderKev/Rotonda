package com.rolosdev.seminarioproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "RESTAURANTE")
public class Restaurante {

    @Id
    @Column(name = "IDRESTAURANTE", nullable = false)
    private int idRestaurante;

    @Column(name = "NOM_RESTAURANTE", nullable = false)
    private String nombre;

    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @Column(name = "USUARIO_RESTAURANTE", nullable = false)
    private String user;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "IMAGEN_RESTAURANTE", nullable = false)
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Especialidad.class)
    @JoinColumn(name = "IDESPECIALIDAD", nullable = false)
    private Especialidad especialidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Stock> stocks;

}
