package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINISTRADOR")
public class Administrador {

    @Id
    @Column(name = "ADMINISTRADOR", nullable = false)
    private int administradorId;
    @Column(name = "USER_ADMINISTRADOR", nullable = false)
    private String userAdministrador;
    @Column(name = "PASSWORD_ADMINISTRADOR", nullable = false)
    private String password;

    public int getAdministradorId() {
        return administradorId;
    }

    public void setAdministradorId(int administrador) {
        this.administradorId = administrador;
    }

    public String getUserAdministrador() {
        return userAdministrador;
    }

    public void setUserAdministrador(String userAdministrador) {
        this.userAdministrador = userAdministrador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
