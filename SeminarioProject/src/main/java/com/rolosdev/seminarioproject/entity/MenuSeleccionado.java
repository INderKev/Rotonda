package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "MENU_SELECCIONADO")
public class MenuSeleccionado {

    @Id
    @Column(name = "IDMENU_SELECCIONADO", nullable = false)
    private int idMenuSeleccionado;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Menu.class)
    @JoinColumn(name = "IDMENU", nullable = false)
    private Menu menu;

}
