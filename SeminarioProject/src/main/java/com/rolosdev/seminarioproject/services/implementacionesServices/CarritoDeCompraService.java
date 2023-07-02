package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.SalesResources.PaqueteMenuSeleccionado;
import com.rolosdev.seminarioproject.SalesResources.PaqueteOrden;
import com.rolosdev.seminarioproject.entity.Compra;
import com.rolosdev.seminarioproject.entity.Producto;

import java.util.ArrayList;

public class CarritoDeCompraService {

    static public CarritoDeCompraService carritoDeCompraService;
    public Compra compra;
    public ArrayList<PaqueteOrden> ordenes;

    private CarritoDeCompraService() {
        ordenes = new ArrayList<>();
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void agregarPaqueteDeOrden(PaqueteOrden paqueteOrden) {
        if (ordenes == null) {
            ordenes = new ArrayList<>();
        }
        ordenes.add(paqueteOrden);
    }

    public PaqueteOrden obtenerOrdenPorMenuSeleccionado(int idMenuSeleccionado) {
        for (PaqueteOrden paqueteOrden : ordenes) {
            if (paqueteOrden.getPaqueteMenuSeleccionado() != null) {
                if (paqueteOrden.getPaqueteMenuSeleccionado().getMenuSeleccionado().getIdMenuSeleccionado() == idMenuSeleccionado) {
                    return paqueteOrden;
                }
            }
        }
        return null;
    }

    public PaqueteOrden obtenerOrdenPorProducto(int idProducto) {
        for (PaqueteOrden paqueteOrden : ordenes) {
            if (paqueteOrden.getPaqueteProducto() != null) {
                if (paqueteOrden.getPaqueteProducto().getProducto().getIdProducto() == idProducto) {
                    return paqueteOrden;
                }
            }
        }
        return null;
    }

    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        for (PaqueteOrden orden : ordenes) {
            if (orden.getPaqueteProducto() != null) {
                productos.add(orden.getPaqueteProducto().producto);
            }
        }
        return productos;
    }

    public ArrayList<PaqueteMenuSeleccionado> getMenusSeleccionados() {
        ArrayList<PaqueteMenuSeleccionado> menuSeleccionado = new ArrayList<>();
        for (PaqueteOrden orden : ordenes) {
            if (orden.getPaqueteMenuSeleccionado() != null) {
                menuSeleccionado.add(orden.getPaqueteMenuSeleccionado());
            }
        }
        return menuSeleccionado;
    }

    public void eliminarOrden(PaqueteOrden paqueteOrden) {
        ordenes.remove(paqueteOrden);
    }

    public void finalizar() {
        compra = null;
        ordenes.clear();
    }

    static public CarritoDeCompraService getCarritoDeCompraService(){
        if (carritoDeCompraService == null){
            carritoDeCompraService = new CarritoDeCompraService();
        }
        return carritoDeCompraService;
    }

    public ArrayList<PaqueteOrden> getOrdenes() {
        return ordenes;
    }
}
