package com.rolosdev.seminarioproject.SalesResources;

import com.rolosdev.seminarioproject.entity.Producto;

import java.util.ArrayList;

public class PaqueteProducto {

    public Producto producto;
    public ArrayList<PaqueteProductoIngrediente> paquetesProductoIngredientes;

    public PaqueteProducto() {
        paquetesProductoIngredientes = new ArrayList<>();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<PaqueteProductoIngrediente> getPaquetesProductoIngredientes() {
        return paquetesProductoIngredientes;
    }

    public void setPaquetesProductoIngredientes(ArrayList<PaqueteProductoIngrediente> paquetesProductoIngredientes) {
        this.paquetesProductoIngredientes = paquetesProductoIngredientes;
    }

    public void agregarPaqueteProductoIngrediente(PaqueteProductoIngrediente paqueteProductoIngrediente) {
        paquetesProductoIngredientes.add(paqueteProductoIngrediente);
    }
}
