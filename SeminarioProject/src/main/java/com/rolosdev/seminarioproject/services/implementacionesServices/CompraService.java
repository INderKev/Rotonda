package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.SalesResources.PaqueteMenuSeleccionado;
import com.rolosdev.seminarioproject.SalesResources.PaqueteOrden;
import com.rolosdev.seminarioproject.SalesResources.PaqueteProducto;
import com.rolosdev.seminarioproject.SalesResources.PaqueteProductoIngrediente;
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

    @Override
    public ArrayList<Menu> obtenerMenusDisponibles(int idRestaurante) {
        boolean confirmar;
        ArrayList<Menu> menus = menuRepository.obtenerMenusPorRestaurante(idRestaurante);
        ArrayList<Menu> menusDescartados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Producto> productosEliminados = new ArrayList<>();
        ArrayList<Producto> productosObtenidos;
        for (Menu menu : menus) {
            productosObtenidos = obtenerProductosPorMenu(menu.getIdMenu());
            for (Producto productoObtenido : productosObtenidos) {
                confirmar = true;
                for (Producto producto : productos) {
                    if (producto.getIdProducto() == productoObtenido.getIdProducto()) {
                        confirmar = false;
                    }
                }
                if (confirmar) {
                    productos.add(productoObtenido);
                }
            }
        }
        for (Producto producto: productos) {
            if (!verificarQueSePuedePrepararProducto(producto)) {
                productosEliminados.add(producto);
            }
        }
        for (Producto producto: productosEliminados) {
            productos.remove(producto);
        }
        for (Menu menu : menus) {
            ArrayList<Seleccion> selecciones = seleccionRepository.obtenerSeleccionPorMenu(menu.getIdMenu());
            for (Seleccion seleccion : selecciones) {
                confirmar = true;
                for (Producto producto : productos) {
                    if (producto.getIdClasificacion() == seleccion.getIdClasificacion() && producto.getPrecio() <= seleccion.getPrecioAlto() && producto.getPrecio() >= seleccion.getPrecioBajo()) {
                        confirmar = false;
                        break;
                    }
                }
                if (confirmar) {
                    menusDescartados.add(menu);
                    break;
                }
            }
        }
        for (Menu menu : menusDescartados) {
            menus.remove(menu);
        }
        return menus;
    }

    @Override
    public ArrayList<Producto> obtenerProductosDisponibles(int idRestaurante) {
        ArrayList<Producto> productos = productoRepository.obtenerProductosPorRestaurante(idRestaurante);
        ArrayList<Producto> productosEliminados = new ArrayList<>();
        for (Producto producto: productos) {
            if (!verificarQueSePuedePrepararProducto(producto)) {
                productosEliminados.add(producto);
            }
        }
        for (Producto producto: productosEliminados) {
            productos.remove(producto);
        }
        return productos;
    }

    @Override
    public void iniciarCompra() {
        Compra compra = new Compra();
        compra.setIdCompra(compraRepository.obtenerUltimoId().getIdCompra() + 1);
        compra.setFecha(LocalDate.now());
        compra.setTotal(0);
        compra.setIdCliente(UsuarioLogueadoService.getUsuarioLogueadoService().getCliente().getIdCliente());
        compraRepository.save(compra);
        CarritoDeCompraService.getCarritoDeCompraService().setCompra(compra);
    }

    @Override
    public void cancelarCompra() {
        compraRepository.delete(CarritoDeCompraService.getCarritoDeCompraService().getCompra());

    }

    @Override
    public void terminarCompra() {

    }

    @Override
    public int crearMenuSeleccionado(int idMenu) {
        MenuSeleccionado menuSeleccionado = new MenuSeleccionado();
        Menu menu = new Menu();
        menu = menuRepository.findById(idMenu).get();
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
        paqueteMenuSeleccionado.setSelecciones(seleccionRepository.obtenerSeleccionPorMenu(menuSeleccionado.getIdMenu()));
        ArrayList<Producto> productosMenu = productoRepository.obtenerProductosPorMenu(menuSeleccionado.getIdMenu());
        for (Producto producto : productosMenu) {
            descontarCantidadStock(producto);
            PaqueteProducto paqueteProducto = new PaqueteProducto();
            paqueteProducto.setProducto(producto);
            ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(producto.getIdProducto());
            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                PaqueteProductoIngrediente paqueteProductoIngrediente = new PaqueteProductoIngrediente();
                paqueteProductoIngrediente.setProductoIngrediente(productoIngrediente);
                paqueteProductoIngrediente.setIngrediente(ingredienteRepository.findById(productoIngrediente.getIdIngrediente()).orElse(null));
                paqueteProducto.agregarPaqueteProductoIngrediente(paqueteProductoIngrediente);
            }
            paqueteMenuSeleccionado.agregarProducto(paqueteProducto);
        }
        CarritoDeCompraService.getCarritoDeCompraService().agregarPaqueteDeOrden(paqueteOrden);
        CarritoDeCompraService.getCarritoDeCompraService().compra.setTotal(CarritoDeCompraService.getCarritoDeCompraService().compra.getTotal() + menu.getPrecio());
        return menuSeleccionado.getIdMenuSeleccionado();
    }

    @Override
    public void seleccionarProductoParaMenu(int idProducto, int idMenuSeleccionado) {
        Producto producto = productoRepository.findById(idProducto).get();
        PaqueteProducto paqueteProducto = new PaqueteProducto();
        paqueteProducto.setProducto(producto);
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(producto.getIdProducto());
        for (ProductoIngrediente productoIngrediente : productosIngredientes) {
            PaqueteProductoIngrediente paqueteProductoIngrediente = new PaqueteProductoIngrediente();
            paqueteProductoIngrediente.setProductoIngrediente(productoIngrediente);
            paqueteProductoIngrediente.setIngrediente(ingredienteRepository.findById(productoIngrediente.getIdIngrediente()).orElse(null));
            paqueteProducto.agregarPaqueteProductoIngrediente(paqueteProductoIngrediente);
        }
        PaqueteOrden paqueteOrden = CarritoDeCompraService.carritoDeCompraService.obtenerOrdenPorMenuSeleccionado(idMenuSeleccionado);
        paqueteOrden.getPaqueteMenuSeleccionado().agregarProductoSeleccionado(paqueteProducto);
    }

    @Override
    public void agregarProducto(int idProducto) {
        Producto producto = productoRepository.findById(idProducto).get();
        PaqueteProducto paqueteProducto = new PaqueteProducto();
        paqueteProducto.setProducto(producto);
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(producto.getIdProducto());
        for (ProductoIngrediente productoIngrediente : productosIngredientes) {
            PaqueteProductoIngrediente paqueteProductoIngrediente = new PaqueteProductoIngrediente();
            paqueteProductoIngrediente.setProductoIngrediente(productoIngrediente);
            paqueteProductoIngrediente.setIngrediente(ingredienteRepository.findById(productoIngrediente.getIdIngrediente()).orElse(null));
            paqueteProducto.agregarPaqueteProductoIngrediente(paqueteProductoIngrediente);
        }
        Orden orden = new Orden();
        orden.setIdOrden(ordenRepository.obtenerUltimoId().getIdOrden());
        orden.setIdCompra(CarritoDeCompraService.getCarritoDeCompraService().getCompra().getIdCompra());
        PaqueteOrden paqueteOrden = new PaqueteOrden();
        paqueteOrden.setOrden(orden);
        paqueteOrden.setPaqueteProducto(paqueteProducto);
    }

    @Override
    public void quitarSeleccionMenuCarrito(int idMenuSeleccionado) {
        PaqueteOrden paqueteOrden = CarritoDeCompraService.getCarritoDeCompraService().obtenerOrdenPorMenuSeleccionado(idMenuSeleccionado);
        MenuSeleccionado menuSeleccionado = menuSeleccionadoRepository.findById(idMenuSeleccionado).get();
        Menu menu = menuRepository.findById(menuSeleccionado.getIdMenu()).get();
        for (PaqueteProducto producto: paqueteOrden.getPaqueteMenuSeleccionado().getProductos()) {
            recuperarCantidadStock(producto.getProducto());
        }
        menuSeleccionadoRepository.deleteById(idMenuSeleccionado);
        CarritoDeCompraService.getCarritoDeCompraService().compra.setTotal(CarritoDeCompraService.getCarritoDeCompraService().compra.getTotal() - menu.getPrecio());
        CarritoDeCompraService.getCarritoDeCompraService().eliminarOrden(paqueteOrden);
        menuSeleccionadoRepository.deleteById(idMenuSeleccionado);
    }

    @Override
    public void quitarSeleccionProducto(int idProducto) {
        
    }

    public ArrayList<Producto> obtenerProductosPorMenu(int idMenu) {
        boolean confirmar;
        ArrayList<Producto> productosAEliminar = new ArrayList<>();
        ArrayList<Producto> opcionesProductosMenu = productoRepository.obtenerProductosPorMenu(idMenu);
        ArrayList<Stock> stocks = stockRepository.obtenerStockPorMenu(idMenu);
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredientePorMenu(idMenu);
        for (Producto producto : opcionesProductosMenu) {
            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                if (productoIngrediente.getIdProducto() == producto.getIdProducto()) {
                    for (Stock stock : stocks) {
                        if (stock.getIdRestaurante() == producto.getIdRestaurante() && productoIngrediente.getIdIngrediente() == stock.getIdIngrediente()) {
                            if (stock.getCantidadStock() < productoIngrediente.getCantidad()) {
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
        return opcionesProductosMenu;
    }

    private void descontarCantidadStock(Producto producto) {
        ArrayList<Stock> stocks = stockRepository.obtenerStockPorProducto(producto.getIdProducto());
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(producto.getIdProducto());
        for (ProductoIngrediente productoIngrediente : productosIngredientes) {
            for (Stock stock : stocks) {
                if (productoIngrediente.getIdIngrediente() == stock.getIdIngrediente()) {
                    stock.setCantidadStock(stock.getCantidadStock() - productoIngrediente.getCantidad());
                    stockRepository.save(stock);
                    break;
                }
            }
        }
    }

    private void recuperarCantidadStock(Producto producto) {
        ArrayList<Stock> stocks = stockRepository.obtenerStockPorProducto(producto.getIdProducto());
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(producto.getIdProducto());
        for (ProductoIngrediente productoIngrediente : productosIngredientes) {
            for (Stock stock : stocks) {
                if (productoIngrediente.getIdIngrediente() == stock.getIdIngrediente()) {
                    stock.setCantidadStock(stock.getCantidadStock() + productoIngrediente.getCantidad());
                    stockRepository.save(stock);
                    break;
                }
            }
        }
    }

    private boolean verificarQueSePuedePrepararProducto(Producto producto) {
        ArrayList<Stock> stocks = stockRepository.obtenerStockPorProducto(producto.getIdProducto());
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(producto.getIdProducto());
        boolean confirmar;
        for (ProductoIngrediente productoIngrediente : productosIngredientes) {
            confirmar = true;
            for (Stock stock : stocks) {
                if (productoIngrediente.getIdIngrediente() == stock.getIdIngrediente() && productoIngrediente.getCantidad() <= stock.getCantidadStock()) {
                    confirmar = false;
                    break;
                }
            }
            if (confirmar) {
                return false;
            }
        }
        return true;
    }

}
