package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.Compra;
import com.rolosdev.seminarioproject.entity.Menu;

import java.util.ArrayList;

public interface ICompraService {

    public ArrayList<Menu> obtenerMenusDisponibles(int idRestaurante);
    public void iniciarCompra();
    public void cancelarCompra();
    public void terminarCompra();
    public void crearMenuSeleccionado(int idMenu);
    public void seleccionarProductoParaMenu(int idProducto, int idMenuSeleccionado);
    public void agregarMenuCarrito(int idMenuSeleccionado);
    public void agregarProducto(int idProducto);
    public void quitarSeleccionMenuCarrito(int idMenuSeleccionado);
    public void quitarSeleccionProducto(int idProducto);


}
