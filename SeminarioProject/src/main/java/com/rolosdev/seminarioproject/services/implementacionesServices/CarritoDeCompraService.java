package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.SalesResources.PaqueteOrden;
import com.rolosdev.seminarioproject.entity.Compra;

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



    static public CarritoDeCompraService getCarritoDeCompraService(){
        if (carritoDeCompraService == null){
            carritoDeCompraService = new CarritoDeCompraService();
        }
        return carritoDeCompraService;
    }
}
