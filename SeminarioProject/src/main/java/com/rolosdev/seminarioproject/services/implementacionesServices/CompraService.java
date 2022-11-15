package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.SalesResources.PaqueteMenuSeleccionado;
import com.rolosdev.seminarioproject.SalesResources.PaqueteOrden;
import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.repository.*;
import com.rolosdev.seminarioproject.services.interfacesServices.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

@Service("compraService")
@Transactional
public class CompraService implements ICompraService {

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

    @Autowired
    @Qualifier("stockRepository")
    private IStockRepository stockRepository;

    public String iniciarCompra() {
        Compra compra = new Compra();
        compra.setIdCompra(compraRepository.obtenerUltimoId().getIdCompra() + 1);
        compra.setFecha(LocalDate.now());
        compra.setTotal(0);
        compra.setIdCliente(UsuarioLogueadoService.getUsuarioLogueadoService().getCliente().getIdCliente());
        compraRepository.save(compra);
        CarritoDeCompraService.getCarritoDeCompraService().setCompra(compra);
        return null;
    }

    public String cancelarCompra() {

        return null;
    }

    public String terminarCompra() {
        return null;
    }

    public void crearMenuSeleccionado(int idMenu) {
        boolean confirmar;
        MenuSeleccionado menuSeleccionado = new MenuSeleccionado();
        menuSeleccionado.setIdMenu(idMenu);
        menuSeleccionado.setIdMenuSeleccionado(menuSeleccionadoRepository.obtenerUltimoId().getIdMenuSeleccionado() + 1);
        Orden orden = new Orden();
        orden.setIdOrden(ordenRepository.obtenerUltimoId().getIdOrden());
        orden.setIdCompra(CarritoDeCompraService.getCarritoDeCompraService().getCompra().getIdCompra());
        orden.setIdMenuSeleccionado(menuSeleccionado.getIdMenuSeleccionado());
        orden.setObservaciones("");
        PaqueteOrden paqueteOrden = new PaqueteOrden();
        paqueteOrden.setOrden(orden);
        PaqueteMenuSeleccionado paqueteMenuSeleccionado = new PaqueteMenuSeleccionado();
        paqueteMenuSeleccionado.setMenuSeleccionado(menuSeleccionado);
        paqueteOrden.setPaqueteMenuSeleccionado(paqueteMenuSeleccionado);
        ArrayList<Producto> productosAEliminar = new ArrayList<>();
        //ArrayList<Seleccion> seleccionesMenu = seleccionRepository.obtenerSeleccionPorMenu(menuSeleccionado.getIdMenu());
        ArrayList<Producto> opcionesProductosMenu = productoRepository.obtenerProductosPorMenu(menuSeleccionado.getIdMenu());
        ArrayList<Ingrediente> ingredientesParaTodosLosProductos = ingredienteRepository.obtenerIngredientesPorMenu(menuSeleccionado.getIdMenu());
        ArrayList<Stock> stocks = stockRepository.obtenerStockPorMenu(menuSeleccionado.getIdMenu());
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredientePorMenu(menuSeleccionado.getIdMenu());
        for (Producto producto : opcionesProductosMenu) {
            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                if (productoIngrediente.getIdProducto() == producto.getIdProducto()) {
                    for (Stock stock : stocks) {
                        if (stock.getIdRestaurante() == producto.getIdRestaurante() && productoIngrediente.getIdIngrediente() == stock.getIdIngrediente()) {
                            System.out.println("Cantidad en stock: " + stock.getCantidadStock() + " - ingrediente: " + stock.getIdIngrediente());
                            System.out.println("Cantidad de producto: " + productoIngrediente.getCantidad() + " - ingrediente: " + productoIngrediente.getIdIngrediente());
                            if (stock.getCantidadStock() < productoIngrediente.getCantidad()) {
                                System.out.println("Eliminar----------------------------------------------------------------");
                                confirmar = true;
                                for (Producto productoAEliminar : productosAEliminar) {
                                    if (productoAEliminar.equals(producto)) {
                                        confirmar = false;
                                        break;
                                    }
                                }
                                if (confirmar) {
                                    productosAEliminar.add(producto);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Producto producto : productosAEliminar) {
            opcionesProductosMenu.remove(producto);
        }
        for (Producto producto : opcionesProductosMenu) {
            System.out.println("Producto: " + producto.getNombre());
        }
        for (Producto producto : opcionesProductosMenu) {
            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                if (productoIngrediente.getIdProducto() == producto.getIdProducto()) {
                    for (Stock stock : stocks) {
                        if (stock.getIdRestaurante() == producto.getIdRestaurante() && productoIngrediente.getIdIngrediente() == stock.getIdIngrediente()) {
                            stock.setCantidadStock(stock.getCantidadStock() - productoIngrediente.getCantidad());
                            stockRepository.save(stock);
                            break;
                        }
                    }
                }
            }
        }
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

    public void actualizarTotalCompra(Compra compra) {
        compraRepository.save(compra);
    }



}
