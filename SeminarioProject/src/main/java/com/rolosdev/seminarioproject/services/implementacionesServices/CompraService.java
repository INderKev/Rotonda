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
        ArrayList<Producto> productos = CarritoDeCompraService.getCarritoDeCompraService().getProductos();
        ArrayList<PaqueteMenuSeleccionado> paquetesMenusSeleccionados = CarritoDeCompraService.getCarritoDeCompraService().getMenusSeleccionados();
        for (PaqueteMenuSeleccionado paqueteMenuSeleccionado : paquetesMenusSeleccionados) {
            ArrayList<PaqueteProducto> productosMenu = paqueteMenuSeleccionado.getProductos();
            for (PaqueteProducto paqueteProducto : productosMenu) {
                productos.add(paqueteProducto.getProducto());
            }
            menuSeleccionadoRepository.delete(paqueteMenuSeleccionado.getMenuSeleccionado());
        }
        for (Producto producto : productos) {
            recuperarCantidadStock(producto);
        }
        CarritoDeCompraService.getCarritoDeCompraService().finalizar();
    }

    @Override
    public String terminarCompra() {
        if (CarritoDeCompraService.getCarritoDeCompraService().getOrdenes().isEmpty())
            return "¡Ninguna orden en el carrito! Primero debes añadir algo.";
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Producto> productosUsados = new ArrayList<>();
        for (PaqueteMenuSeleccionado paqueteMenuSeleccionado : CarritoDeCompraService.getCarritoDeCompraService().getMenusSeleccionados()) {
            productos = new ArrayList<>();
            productosUsados = new ArrayList<>();
            for (PaqueteProducto paqueteProducto : paqueteMenuSeleccionado.getProductos()) {
                productos.add(paqueteProducto.getProducto());
                for (PaqueteProducto pq : paqueteMenuSeleccionado.getProductosSeleccionados()) {
                    if (pq.getProducto().getIdProducto() == paqueteProducto.getProducto().getIdProducto()) {
                        productosUsados.add(paqueteProducto.getProducto());
                        break;
                    }
                }
            }
            for (Producto pr : productosUsados) {
                productos.remove(pr);
            }
            for (Producto producto : productos) {
                recuperarCantidadStock(producto);
            }
            for (Seleccion seleccion : paqueteMenuSeleccionado.getSelecciones()) {
                seleccionRepository.save(seleccion);
            }
        }
        compraRepository.save(CarritoDeCompraService.getCarritoDeCompraService().getCompra());
        for (PaqueteOrden orden : CarritoDeCompraService.getCarritoDeCompraService().getOrdenes()) {
            ordenRepository.save(orden.getOrden());
        }
        CarritoDeCompraService.getCarritoDeCompraService().finalizar();
        return "OK";
    }

    @Override
    public MenuSeleccionado crearMenuSeleccionado(int idMenu) {
        MenuSeleccionado menuSeleccionado = new MenuSeleccionado();
        Menu menu = menuRepository.findById(idMenu).get();
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
        //paqueteMenuSeleccionado.setSelecciones(seleccionRepository.obtenerSeleccionPorMenu(menuSeleccionado.getIdMenu()));
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
        menuSeleccionadoRepository.save(menuSeleccionado);
        return menuSeleccionado;
    }

    @Override
    public void seleccionarProductoParaMenu(int idProducto, int idMenuSeleccionado) {
        Producto producto = productoRepository.findById(idProducto).get();
        PaqueteProducto paqueteProducto = new PaqueteProducto();
        Seleccion seleccion = new Seleccion();
        seleccion.setIdSeleccion(seleccionRepository.obtenerUltimoId().getIdSeleccion() + 1);
        seleccion.setIdMenuSeleccionado(idMenuSeleccionado);
        seleccion.setIdProducto(idProducto);
        seleccion.setIdClasificacion(producto.getIdClasificacion());
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
        paqueteOrden.getPaqueteMenuSeleccionado().agregaSeleccion(seleccion);
    }

    @Override
    public void agregarProductoCarrito(int idProducto) {
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
        orden.setObservaciones("");
        PaqueteOrden paqueteOrden = new PaqueteOrden();
        paqueteOrden.setOrden(orden);
        paqueteOrden.setPaqueteProducto(paqueteProducto);
        CarritoDeCompraService.getCarritoDeCompraService().agregarPaqueteDeOrden(paqueteOrden);
        CarritoDeCompraService.getCarritoDeCompraService().getCompra().setTotal(CarritoDeCompraService.getCarritoDeCompraService().getCompra().getTotal() + producto.getPrecio());
        descontarCantidadStock(producto);
    }

    @Override
    public void quitarSeleccionMenuCarrito(int idMenuSeleccionado) {
        PaqueteOrden paqueteOrden = CarritoDeCompraService.getCarritoDeCompraService().obtenerOrdenPorMenuSeleccionado(idMenuSeleccionado);
        MenuSeleccionado menuSeleccionado = menuSeleccionadoRepository.findById(idMenuSeleccionado).get();
        Menu menu = menuRepository.findById(menuSeleccionado.getIdMenu()).get();
        for (PaqueteProducto producto: paqueteOrden.getPaqueteMenuSeleccionado().getProductos()) {
            recuperarCantidadStock(producto.getProducto());
        }
        CarritoDeCompraService.getCarritoDeCompraService().compra.setTotal(CarritoDeCompraService.getCarritoDeCompraService().getCompra().getTotal() - menu.getPrecio());
        CarritoDeCompraService.getCarritoDeCompraService().eliminarOrden(paqueteOrden);
        menuSeleccionadoRepository.deleteById(idMenuSeleccionado);
    }

    @Override
    public void quitarSeleccionProducto(int idProducto) {
        recuperarCantidadStock(productoRepository.findById(idProducto).get());
        CarritoDeCompraService.getCarritoDeCompraService().getCompra().setTotal(CarritoDeCompraService.getCarritoDeCompraService().getCompra().getTotal() - productoRepository.findById(idProducto).get().getPrecio());
        CarritoDeCompraService.getCarritoDeCompraService().eliminarOrden(CarritoDeCompraService.getCarritoDeCompraService().obtenerOrdenPorProducto(idProducto));
    }

    @Override
    public ArrayList<Menu> obtenerMenusCarro() {
        ArrayList<Menu> menus = new ArrayList<>();
        boolean confirmar;
        for (PaqueteMenuSeleccionado paqueteMenuSeleccionado : CarritoDeCompraService.getCarritoDeCompraService().getMenusSeleccionados()) {
            confirmar = true;
            for (Menu menu : menus) {
                if (menu.getIdMenu() == menuRepository.findById(paqueteMenuSeleccionado.menuSeleccionado.getIdMenu()).get().getIdMenu()) {
                    confirmar = false;
                    break;
                }
            }
            if (confirmar) {
                menus.add(menuRepository.findById(paqueteMenuSeleccionado.menuSeleccionado.getIdMenu()).get());
            }
        }
        return menus;
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
