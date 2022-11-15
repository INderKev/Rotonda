package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.entity.ProductoIngrediente;
import com.rolosdev.seminarioproject.repository.*;
import com.rolosdev.seminarioproject.services.interfacesServices.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service("consultaService")
@Transactional
public class ConsultaService implements IConsultaService {

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
        return productoRepository.obtenerProductosPorMenu(idMenu);
    }

    public ArrayList<Ingrediente> obtenerIngredientesPorProducto(int idProducto) {
        return ingredienteRepository.obtenerIngredientesPorProducto(idProducto);
    }

    public ArrayList<ProductoIngrediente> obtenerProductoIngrediente(int idProducto) {
        return productoIngredienteRepository.obtenerProductoIngredietePorProducto(idProducto);
    }

}
