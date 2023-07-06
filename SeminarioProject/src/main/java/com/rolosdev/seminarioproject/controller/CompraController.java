package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.SalesResources.PaqueteMenuSeleccionado;
import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.services.CarritoDeCompraService;
import com.rolosdev.seminarioproject.services.CompraService;
import com.rolosdev.seminarioproject.services.ConsultaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
@RequestMapping
public class CompraController {

    public CarritoDeCompraService carritoDeCompraService = CarritoDeCompraService.getCarritoDeCompraService();

    @Autowired
    @Qualifier("compraService")
    private CompraService compraService;

    @Autowired
    @Qualifier("consultaService")
    private ConsultaService consultaService;

    @GetMapping("/pruebasCompra")
    public String pruebasCompra(Model model) {
        ArrayList<Menu> menus = compraService.obtenerMenusDisponibles(1);
        System.out.println("\n\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*\n");
        for (Menu menu : menus) {
            System.out.println(menu.getNombre());
        }
        System.out.println("\n/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*\n\n");
        return "/index";
    }

    @GetMapping("/seleccionarRestaurante/{idRestaurante}")
    public String seleccionarRestaurante(@PathVariable("idRestaurante") int idRestaurante, Model model) {
        model.addAttribute("menus", compraService.obtenerMenusDisponibles(idRestaurante));
        model.addAttribute("productos", compraService.obtenerProductosDisponibles(idRestaurante));
        model.addAttribute("restaurante", consultaService.obtenerRestauranteById(idRestaurante));
        return "/listarProductosYCombos";
    }


    @GetMapping("/seleccionarProducto/{idProducto}/detail/{idRestaurante}")
    public String seleccionarProducto(@PathVariable("idProducto") int idProducto, @PathVariable("idRestaurante") int idRestaurante, Model model) {
        if (carritoDeCompraService.getCompra() == null) {
            compraService.iniciarCompra();
        }
        compraService.agregarProductoCarrito(idProducto);
        return "redirect:/seleccionarRestaurante/" + idRestaurante;
    }

    @GetMapping("/quitarProductoCarrito/{idProducto}")
    public String quitarProductoCarrito(@PathVariable("idProducto") int idProducto, Model model) {
        compraService.quitarSeleccionProducto(idProducto);
        return "redirect:/verCarrito";
    }

    @GetMapping("/quitarMenuCarrito/{idMenuSeleccionado}")
    public String quitarMenuCarrito(@PathVariable("idMenuSeleccionado") int idMenuSeleccionado, Model model) {
        compraService.quitarSeleccionMenuCarrito(idMenuSeleccionado);
        return "redirect:/verCarrito";
    }

    @GetMapping("/verCarrito")
    public String verCarrito(Model model) {
        ArrayList<MenuSeleccionado> menusSeleccionados = new ArrayList<>();
        for (PaqueteMenuSeleccionado paqueteMenuSeleccionado : CarritoDeCompraService.getCarritoDeCompraService().getMenusSeleccionados()) {
            menusSeleccionados.add(paqueteMenuSeleccionado.getMenuSeleccionado());
        }
        
        model.addAttribute("productos", carritoDeCompraService.getProductos());
        model.addAttribute("menus", compraService.obtenerMenusCarro());
        model.addAttribute("menusSeleccionados", menusSeleccionados);
        model.addAttribute("compra", carritoDeCompraService.getCompra());
        return "/carrito";
    }

    

    @GetMapping("/cancelarCompra")
    public String cancelarCompra(Model model) {
        compraService.cancelarCompra();
        return "redirect:/home";
    }

    @GetMapping("/realizarPago")
    public String realizarPago(Model model) {
        return "/pago";
    }



    @GetMapping("/pagarCompra")
    public String pagarCompra(Model model) {

        compraService.terminarCompra();
        return "redirect:/home";
    }


    @GetMapping("/seleccionarMenu/{idMenu}")
    public String seleccionarProducto(@PathVariable("idMenu") int idMenu, Model model) {
        if (carritoDeCompraService.getCompra() == null) {
            compraService.iniciarCompra();
        }
        MenuSeleccionado menuSeleccionado = compraService.crearMenuSeleccionado(idMenu);
        ArrayList<Producto> productos = consultaService.obtenerProductosPorMenu(idMenu);
        ArrayList<Producto> entradas = new ArrayList<>();
        ArrayList<Producto> platosFuertes = new ArrayList<>();
        ArrayList<Producto> postres = new ArrayList<>();
        ArrayList<Producto> bebidas = new ArrayList<>();
        ArrayList<Producto> acompaniamientos = new ArrayList<>();
        ArrayList<Producto> comidasRapidas = new ArrayList<>();
        for (Producto producto: productos) {
            switch (producto.getClasificacion().getIdClasificacion()) {
                case 1:
                    entradas.add(producto);
                    break;
                case 2:
                    platosFuertes.add(producto);
                    break;
                case 3:
                    postres.add(producto);
                    break;
                case 4:
                    bebidas.add(producto);
                    break;
                case 5:
                    acompaniamientos.add(producto);
                    break;
                case 6:
                    comidasRapidas.add(producto);
                    break;
            }
        }
        boolean isEntrada = false, isPlatoFuerte = false, isPostre = false, isBebida = false, isAcompniamiento = false, iscComidaRápida = false;
        ArrayList<Seleccion> selecciones = consultaService.obtenerSeleccionesPorMenu(idMenu);
        for (Seleccion seleccion : selecciones) {
            switch (seleccion.getClasificacion().getIdClasificacion()) {
                case 1:
                    isEntrada = true;
                    break;
                case 2:
                    isPlatoFuerte = true;
                    break;
                case 3:
                    isPostre = true;
                    break;
                case 4:
                    isBebida = true;
                    break;
                case 5:
                    isAcompniamiento = true;
                    break;
                case 6:
                    iscComidaRápida = true;
                    break;
            }
        }
        ArrayList<Seleccion> seleccionesUsadas = CarritoDeCompraService.getCarritoDeCompraService().obtenerOrdenPorMenuSeleccionado(menuSeleccionado.getIdMenuSeleccionado()).getPaqueteMenuSeleccionado().getSelecciones();
        for (Seleccion seleccion : seleccionesUsadas) {
            switch (seleccion.getClasificacion().getIdClasificacion()) {
                case 1:
                    isEntrada = false;
                    break;
                case 2:
                    isPlatoFuerte = false;
                    break;
                case 3:
                    isPostre = false;
                    break;
                case 4:
                    isBebida = false;
                    break;
                case 5:
                    isAcompniamiento = false;
                    break;
                case 6:
                    iscComidaRápida = false;
                    break;
            }
        }
        if (isEntrada) {
            model.addAttribute("entradas", (entradas));
        }
        if (isPlatoFuerte) {
            model.addAttribute("platosFuertes", (platosFuertes));
        }
        if (isPostre) {
            model.addAttribute("postres", (postres));
        }
        if (isBebida) {
            model.addAttribute("bebidas", (bebidas));
        }
        if (isAcompniamiento) {
            model.addAttribute("acompaniamientos", (acompaniamientos));
        }
        if (iscComidaRápida) {
            model.addAttribute("comidasRapidas", (comidasRapidas));
        }
        model.addAttribute("menuSeleccionado", (menuSeleccionado));
        return "/productosPorCombo";
    }


    @GetMapping("/seleccionarProductoPorMenu/{idProducto}/detail/{idMenuSeleccionado}")
    public String seleccionarProductoPorMenu(@PathVariable("idProducto") int idProducto, @PathVariable("idMenuSeleccionado") int idMenuSeleccionado, Model model) {
        MenuSeleccionado menuSeleccionado = CarritoDeCompraService.getCarritoDeCompraService().obtenerOrdenPorMenuSeleccionado(idMenuSeleccionado).getPaqueteMenuSeleccionado().getMenuSeleccionado();
        compraService.seleccionarProductoParaMenu(idProducto, idMenuSeleccionado);
        ArrayList<Producto> productos = consultaService.obtenerProductosPorMenu(menuSeleccionado.getMenu().getIdMenu());
        ArrayList<Producto> entradas = new ArrayList<>();
        ArrayList<Producto> platosFuertes = new ArrayList<>();
        ArrayList<Producto> postres = new ArrayList<>();
        ArrayList<Producto> bebidas = new ArrayList<>();
        ArrayList<Producto> acompaniamientos = new ArrayList<>();
        ArrayList<Producto> comidasRapidas = new ArrayList<>();
        for (Producto producto: productos) {
            switch (producto.getClasificacion().getIdClasificacion()) {
                case 1:
                    entradas.add(producto);
                    break;
                case 2:
                    platosFuertes.add(producto);
                    break;
                case 3:
                    postres.add(producto);
                    break;
                case 4:
                    bebidas.add(producto);
                    break;
                case 5:
                    acompaniamientos.add(producto);
                    break;
                case 6:
                    comidasRapidas.add(producto);
                    break;
            }
        }
        boolean isEntrada = false, isPlatoFuerte = false, isPostre = false, isBebida = false, isAcompniamiento = false, iscComidaRápida = false;
        ArrayList<Seleccion> selecciones = consultaService.obtenerSeleccionesPorMenu(menuSeleccionado.getMenu().getIdMenu());
        for (Seleccion seleccion : selecciones) {
            switch (seleccion.getClasificacion().getIdClasificacion()) {
                case 1:
                    isEntrada = true;
                    break;
                case 2:
                    isPlatoFuerte = true;
                    break;
                case 3:
                    isPostre = true;
                    break;
                case 4:
                    isBebida = true;
                    break;
                case 5:
                    isAcompniamiento = true;
                    break;
                case 6:
                    iscComidaRápida = true;
                    break;
            }
        }
        ArrayList<Seleccion> seleccionesUsadas = CarritoDeCompraService.getCarritoDeCompraService().obtenerOrdenPorMenuSeleccionado(menuSeleccionado.getIdMenuSeleccionado()).getPaqueteMenuSeleccionado().getSelecciones();
        for (Seleccion seleccion : seleccionesUsadas) {
            switch (seleccion.getClasificacion().getIdClasificacion()) {
                case 1:
                    isEntrada = false;
                    break;
                case 2:
                    isPlatoFuerte = false;
                    break;
                case 3:
                    isPostre = false;
                    break;
                case 4:
                    isBebida = false;
                    break;
                case 5:
                    isAcompniamiento = false;
                    break;
                case 6:
                    iscComidaRápida = false;
                    break;
            }
        }
        if (isEntrada) {
            model.addAttribute("entradas", (entradas));
        }
        if (isPlatoFuerte) {
            model.addAttribute("platosFuertes", (platosFuertes));
        }
        if (isPostre) {
            model.addAttribute("postres", (postres));
        }
        if (isBebida) {
            model.addAttribute("bebidas", (bebidas));
        }
        if (isAcompniamiento) {
            model.addAttribute("acompaniamientos", (acompaniamientos));
        }
        if (iscComidaRápida) {
            model.addAttribute("comidasRapidas", (comidasRapidas));
        }
        model.addAttribute("menuSeleccionado", (menuSeleccionado));

        if (seleccionesUsadas.size() == selecciones.size()) {
            return "redirect:/home";
        }
        return "/productosPorCombo";
    }

}
