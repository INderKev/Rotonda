package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.*;

import java.util.ArrayList;

public interface IConsultaService {

    public ArrayList<Menu> obtenerMenusDelRestaurante(int idRestaurante);
    public ArrayList<Producto> obtenerProductosDelRestaurante(int idRestaurante);
    public ArrayList<Producto> obtenerProductosPorMenu(int idMenu);
    public ArrayList<Ingrediente> obtenerIngredientesPorProducto(int idProducto);
    public ArrayList<ProductoIngrediente> obtenerProductoIngrediente(int idProducto);
    public ArrayList<Restaurante> obtenerRestaurantes();
    public ArrayList<Clasificacion> obtenerClasificaciones();
    public ArrayList<Especialidad> obtenerEspecialidades();
}
