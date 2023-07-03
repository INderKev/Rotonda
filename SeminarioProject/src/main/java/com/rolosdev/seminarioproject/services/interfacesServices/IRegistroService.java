package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.*;

public interface IRegistroService {

    public String registrarCliente(Cliente cliente);
    public String registrarTarjeta(Tarjeta tarjeta);
    public String registrarAdministrador(Administrador administrador);
    public String registrarRestaurante(Restaurante restaurante);
    public String registrarIngrediente(Ingrediente ingrediente);
    public String registrarProducto(Producto producto);
    public String registrarMenu(Menu menu);
    public String registrarProductoIngrediente(ProductoIngrediente productoIngrediente);
    public String registrarSeleccion(Seleccion seleccion);
    public void pruebas();
    public void eliminarProducto(int id);
    public void eliminarMenu(int id);

}
