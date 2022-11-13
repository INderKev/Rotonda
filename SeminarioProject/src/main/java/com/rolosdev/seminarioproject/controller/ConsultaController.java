package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.repository.*;
import com.rolosdev.seminarioproject.services.interfacesServices.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ConsultaController {

    @Autowired
    @Qualifier("consultaService")
    private IConsultaService consultaService;

    @Autowired
    @Qualifier("clienteRepository")
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("compraRepository")
    private ICompraRepository compraRepository;

    @Autowired
    @Qualifier("ingredienteRepository")
    private IIngredienteRepository ingredienteRepository;

    @Autowired
    @Qualifier("menuRepository")
    private IMenuRepository menuRepository;

    @Autowired
    @Qualifier("menuSeleccionadoRepository")
    private IMenuSeleccionadoRepository menuSeleccionadoRepository;

    @Autowired
    @Qualifier("ordenRepository")
    private IOrdenRepository ordenRepository;

    @Autowired
    @Qualifier("productoRepository")
    private IProductoRepository productoRepository;

    @Autowired
    @Qualifier("productoIngredienteRepository")
    private IProductoIngredienteRepository productoIngredienteRepository;

    @Autowired
    @Qualifier("restauranteRepository")
    private IRestauranteRepository restauranteRepository;

    @Autowired
    @Qualifier("seleccionRepository")
    private ISeleccionRepository seleccionRepository;

    public ArrayList<Menu> obtenerMenusDelRestaurante(int idRestaurante) {
        return menuRepository.obtenerMenusPorRestaurante(idRestaurante);
    }

    public ArrayList<Producto> obtenerProductosDelRestaurante(int idRestaurante) {
        return productoRepository.obtenerProductosPorRestaurante(idRestaurante);
    }

    public ArrayList<Producto> obtenerProductosPorMenu(int idMenu) {
        
        return null;
    }

    public ArrayList<Ingrediente> obtenerIngredientesPorProducto(int idProducto) {
        return null;
    }

    public ArrayList<ProductoIngrediente> obtenerProductoIngrediente(int idProducto) {
        return null;
    }

}
