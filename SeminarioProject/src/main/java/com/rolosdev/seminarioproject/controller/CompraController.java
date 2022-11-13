package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.repository.*;
import com.rolosdev.seminarioproject.services.interfacesServices.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CompraController {

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

    public String crearCompra() {
        return null;
    }

    public String crearMenuSeleccionado(int idMenu) {
        return null;
    }

    public String seleccionarProductoParaMenu(int idProducto, int idMenu) {
        return null;
    }

    public String agregarMenuCarrito(int idMenuSeleccionado) {
        return null;
    }

    public String agregarProducto(int idProducto) {
        return null;
    }

    public String quitarSeleccionMenuCarrito(int idMenuSeleccionado) {
        return null;
    }

    public String quitarSeleccionProducto(int idProducto) {
        return null;
    }

}
