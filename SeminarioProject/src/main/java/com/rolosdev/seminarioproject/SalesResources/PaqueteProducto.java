package com.rolosdev.seminarioproject.SalesResources;

import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.entity.ProductoIngrediente;

import java.util.ArrayList;

public class PaqueteProducto {

    public Producto producto;
    public ArrayList<PaqueteProductoIngrediente> paquetesProductoIngredientes;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}
