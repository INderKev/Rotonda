package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import com.rolosdev.seminarioproject.entity.Producto;

import java.util.ArrayList;

public interface ICompraService {

    public ArrayList<Menu> obtenerMenusDisponibles(int idRestaurante);
    public ArrayList<Producto> obtenerProductosDisponibles(int idRestaurante);
    public void iniciarCompra();
    public void cancelarCompra();
    public void terminarCompra();
    public MenuSeleccionado crearMenuSeleccionado(int idMenu);
    public void seleccionarProductoParaMenu(int idProducto, int idMenuSeleccionado);
    public void agregarProductoCarrito(int idProducto);
    public void quitarSeleccionMenuCarrito(int idMenuSeleccionado);
    public void quitarSeleccionProducto(int idProducto);
    public ArrayList<Menu> obtenerMenusCarro();
}
