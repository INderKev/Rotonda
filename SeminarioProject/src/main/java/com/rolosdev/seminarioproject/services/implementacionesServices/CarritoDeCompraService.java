package com.rolosdev.seminarioproject.services.implementacionesServices;

public class CarritoDeCompraService {

    static public CarritoDeCompraService carritoDeCompraService;

    private CarritoDeCompraService() {

    }

    static public CarritoDeCompraService getCarritoDeCompraService(){
        if (carritoDeCompraService == null){
            carritoDeCompraService = new CarritoDeCompraService();
        }
        return carritoDeCompraService;
    }
}
