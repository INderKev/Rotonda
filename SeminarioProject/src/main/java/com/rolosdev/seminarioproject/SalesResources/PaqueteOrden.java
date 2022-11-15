package com.rolosdev.seminarioproject.SalesResources;

import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import com.rolosdev.seminarioproject.entity.Orden;
import com.rolosdev.seminarioproject.entity.ProductoIngrediente;
import com.rolosdev.seminarioproject.repository.ISeleccionRepository;

public class PaqueteOrden {

    public Orden orden;
    public PaqueteMenuSeleccionado paqueteMenuSeleccionado;
    public PaqueteProducto paqueteProducto;

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public PaqueteMenuSeleccionado getPaqueteMenuSeleccionado() {
        return paqueteMenuSeleccionado;
    }

    public void setPaqueteMenuSeleccionado(PaqueteMenuSeleccionado paqueteMenuSeleccionado) {
        this.paqueteMenuSeleccionado = paqueteMenuSeleccionado;
    }

    public PaqueteProducto getPaqueteProducto() {
        return paqueteProducto;
    }

    public void setPaqueteProducto(PaqueteProducto paqueteProducto) {
        this.paqueteProducto = paqueteProducto;
    }



}
