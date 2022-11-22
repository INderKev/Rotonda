package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.Compra;

public interface ICompraService {

    public String iniciarCompra();
    public String cancelarCompra();
    public String terminarCompra();
    public void crearMenuSeleccionado(int idMenu);
    public String seleccionarProductoParaMenu(int idProducto, int idMenuSeleccionado);
    public String agregarMenuCarrito(int idMenuSeleccionado);
    public String agregarProducto(int idProducto);
    public String quitarSeleccionMenuCarrito(int idMenuSeleccionado);
    public String quitarSeleccionProducto(int idProducto);
    public void actualizarTotalCompra(Compra compra);


}
