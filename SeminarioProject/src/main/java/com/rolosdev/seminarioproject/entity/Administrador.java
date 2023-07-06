package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "administrador")
public class Administrador {

    @Id
    @Column(name = "ADMINISTRADORID", nullable = false)
    private int administradorId;

    @Column(name = "USER_ADMINISTRADOR", nullable = false)
    private String userAdministrador;

    @Column(name = "PASSWORD_ADMINISTRADOR", nullable = false)
    private String password;

}
