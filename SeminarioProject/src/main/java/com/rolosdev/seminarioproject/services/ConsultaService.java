package com.rolosdev.seminarioproject.services;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("consultaService")
@Transactional
public class ConsultaService {

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

    @Autowired
    @Qualifier("stockRepository")
    private IStockRepository stockRepository;

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

    public ArrayList<Restaurante> obtenerRestaurantes() {
        return (ArrayList<Restaurante>) restauranteRepository.findAll();
    }

    public Restaurante obtenerRestauranteById(int id) {
        return restauranteRepository.findById(id).get();
    }

    public ArrayList<Clasificacion> obtenerClasificaciones() {
        return clasificacionRepository.obtenerTodasClasificaciones();
    }

    public ArrayList<Especialidad> obtenerEspecialidades() {
        return (ArrayList<Especialidad>) especialidadRepository.findAll();
    }

    public ArrayList<Seleccion> obtenerSeleccionesPorMenu(int idMenu) {
        return seleccionRepository.obtenerSeleccionPorMenu(idMenu);
    }

    public Producto obtenerProductoPorId(int IdProducto) {
        return productoRepository.findById(IdProducto).get();
    }

    public Menu obtenerMenuPorId(int IdMenu){
        return menuRepository.findById(IdMenu).get();
    }

    public List<Stock> obtenerStockPorRestaurante(int restaurante) {
        return stockRepository.obtenerStockPorRestaurante(restaurante);
    }

    public Restaurante obtenerStockRestaurante(int idRestaurante) {
       return restauranteRepository.findById(idRestaurante).get();
    }

    public Stock obtenerStock(int idStock) {
       return stockRepository.findById(idStock).get();
    }

    
    public List<Ingrediente> obteneringredientescomplementorestaurante(int idrestaurante){
        return ingredienteRepository.obtenerIngredientesFaltantesderestaurante(idrestaurante);


    public Map<String, Integer> obtenerListaIngredientesTotales(){
        Map<String, Integer> lista = new HashMap<>();
        List<Object[]> a = ingredienteRepository.listarIngredientes();
        for (Object [] arr: a){
            String key = (String) arr[0];
            BigDecimal value = (BigDecimal)arr[1];
            Integer finalValue = value.intValue();
            lista.put(key, finalValue);
        }
        return lista;
    }

    @Transactional
    public void eliminarIngrediente(String nombIngrediente){
        ingredienteRepository.borarIngrediente(nombIngrediente);
 
    }
}
