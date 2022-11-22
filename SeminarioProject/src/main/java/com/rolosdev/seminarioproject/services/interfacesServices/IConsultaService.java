package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.entity.ProductoIngrediente;

import java.util.ArrayList;

public interface IConsultaService {

    public ArrayList<Menu> obtenerMenusDelRestaurante(int idRestaurante);
    public ArrayList<Producto> obtenerProductosDelRestaurante(int idRestaurante);
    public ArrayList<Producto> obtenerProductosPorMenu(int idMenu);
    public ArrayList<Ingrediente> obtenerIngredientesPorProducto(int idProducto);
    public ArrayList<ProductoIngrediente> obtenerProductoIngrediente(int idProducto);

}
