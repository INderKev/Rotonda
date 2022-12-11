package com.rolosdev.seminarioproject.SalesResources;

import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.entity.Seleccion;


import java.util.ArrayList;

public class PaqueteMenuSeleccionado {

    public MenuSeleccionado menuSeleccionado;
    public ArrayList<Seleccion> selecciones;
    public ArrayList<PaqueteProducto> productos;
    public ArrayList<PaqueteProducto> productosSeleccionados;

    public PaqueteMenuSeleccionado() {
        productos = new ArrayList<>();
        productosSeleccionados = new ArrayList<>();
        selecciones = new ArrayList<>();
    }

    public MenuSeleccionado getMenuSeleccionado() {
        return menuSeleccionado;
    }

    public void setMenuSeleccionado(MenuSeleccionado menuSeleccionado) {
        this.menuSeleccionado = menuSeleccionado;
    }

    public ArrayList<Seleccion> getSelecciones() {
        return selecciones;
    }

    public void setSelecciones(ArrayList<Seleccion> selecciones) {
        this.selecciones = selecciones;
    }

    public ArrayList<PaqueteProducto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<PaqueteProducto> productos) {
        this.productos = productos;
    }

    public ArrayList<PaqueteProducto> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public void setProductosSeleccionados(ArrayList<PaqueteProducto> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    public void agregarProducto(PaqueteProducto producto) {
        productos.add(producto);
    }

    public void agregaSeleccion(Seleccion seleccion) {
        selecciones.add(seleccion);
    }

    public void agregarProductoSeleccionado(PaqueteProducto producto) {
        boolean confirmar = false;
        PaqueteProducto paqueteProductoAEliminar = new PaqueteProducto();
        for (PaqueteProducto paqueteProducto : productosSeleccionados) {
            if (paqueteProducto.getProducto().getIdClasificacion() == producto.getProducto().getIdClasificacion()) {
                confirmar = true;
                paqueteProductoAEliminar = paqueteProducto;
                break;
            }
        }
        if (confirmar) {
            productosSeleccionados.remove(paqueteProductoAEliminar);
        }
        productosSeleccionados.add(producto);
    }
}
