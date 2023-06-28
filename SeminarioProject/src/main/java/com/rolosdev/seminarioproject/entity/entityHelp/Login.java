package com.rolosdev.seminarioproject.entity.entityHelp;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

    @Id
    private int id;
    private String usuario;
    private String pass;
    private String tipoUsuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
