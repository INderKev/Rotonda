package com.rolosdev.seminarioproject.SalesResources;

import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import com.rolosdev.seminarioproject.entity.Seleccion;


import java.util.ArrayList;

public class PaqueteMenuSeleccionado {

    public MenuSeleccionado menuSeleccionado;
    public ArrayList<Seleccion> selecciones;



    public PaqueteMenuSeleccionado() {
        selecciones = new ArrayList<>();
    }

    public MenuSeleccionado getMenuSeleccionado() {
        return menuSeleccionado;
    }

    public void setMenuSeleccionado(MenuSeleccionado menuSeleccionado) {
        this.menuSeleccionado = menuSeleccionado;
    }

    public void agregarSeleccion (Seleccion seleccion) {
        selecciones.add(seleccion);
    }

    public void cambiarSeleccion (Seleccion seleccion) {

    }

    public ArrayList<Seleccion> getSelecciones () {
        return selecciones;
    }

}
