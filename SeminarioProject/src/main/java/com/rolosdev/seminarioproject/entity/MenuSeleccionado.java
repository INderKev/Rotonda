package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_SELECCIONADO")
public class MenuSeleccionado {

    @Id
    @Column(name = "IDMENU_SELECCIONADO", nullable = false)
    private int idMenuSeleccionado;
    @Column(name = "IDMENU", nullable = false)
    private int idMenu;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdMenuSeleccionado() {
        return idMenuSeleccionado;
    }

    public void setIdMenuSeleccionado(int idMenuSeleccionado) {
        this.idMenuSeleccionado = idMenuSeleccionado;
    }
}
