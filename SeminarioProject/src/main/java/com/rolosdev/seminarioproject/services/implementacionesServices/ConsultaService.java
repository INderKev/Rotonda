package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.entity.*;
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
    @Qualifier("clasificacionRepository")
    private IClasificacionRepository clasificacionRepository;

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

    @Autowired
    @Qualifier("especialidadRepository")
    private IEspecialidadRepository especialidadRepository;

    @Override
    public ArrayList<Menu> obtenerMenusDelRestaurante(int idRestaurante) {
        return menuRepository.obtenerMenusPorRestaurante(idRestaurante);
    }

    @Override
    public ArrayList<Producto> obtenerProductosDelRestaurante(int idRestaurante) {
        return productoRepository.obtenerProductosPorRestaurante(idRestaurante);
    }

    @Override
    public ArrayList<Producto> obtenerProductosPorMenu(int idMenu) {
        return productoRepository.obtenerProductosPorMenu(idMenu);
    }

    @Override
    public ArrayList<Ingrediente> obtenerIngredientesPorProducto(int idProducto) {
        return ingredienteRepository.obtenerIngredientesPorProducto(idProducto);
    }

    @Override
    public ArrayList<ProductoIngrediente> obtenerProductoIngrediente(int idProducto) {
        return productoIngredienteRepository.obtenerProductoIngredietePorProducto(idProducto);
    }

    @Override
    public ArrayList<Restaurante> obtenerRestaurantes() {
        return (ArrayList<Restaurante>) restauranteRepository.findAll();
    }

    @Override
    public ArrayList<Clasificacion> obtenerClasificaciones() {
        return clasificacionRepository.obtenerTodasClasificaciones();
    }

    @Override
    public ArrayList<Especialidad> obtenerEspecialidades() {
        return (ArrayList<Especialidad>) especialidadRepository.findAll();
    }

}
