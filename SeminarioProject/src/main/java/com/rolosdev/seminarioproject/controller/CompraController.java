package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.Clasificacion;
import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.services.implementacionesServices.CarritoDeCompraService;
import com.rolosdev.seminarioproject.services.implementacionesServices.CompraService;
import com.rolosdev.seminarioproject.services.implementacionesServices.ConsultaService;
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
        return "/index";
    }

    @GetMapping("/seleccionarMenu/{idMenu}")
    public String seleccionarProducto(@PathVariable("idMenu") int idMenu, Model model) {
        if (carritoDeCompraService.getCompra() != null) {
            compraService.iniciarCompra();
        }
        int idMenuSeleccionado = compraService.crearMenuSeleccionado(idMenu);
        ArrayList<Producto> productos = consultaService.obtenerProductosPorMenu(idMenu);
        ArrayList<Producto> entradas = new ArrayList<>();
        ArrayList<Producto> platosFuertes = new ArrayList<>();
        ArrayList<Producto> postres = new ArrayList<>();
        ArrayList<Producto> bebidas = new ArrayList<>();
        ArrayList<Producto> acompaniamientos = new ArrayList<>();
        ArrayList<Producto> comidasRapidas = new ArrayList<>();
        for (Producto producto: productos) {
            switch (producto.getIdClasificacion()) {
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
        model.addAttribute("entradas", (entradas));
        model.addAttribute("platosFuertes", (platosFuertes));
        model.addAttribute("postres", (postres));
        model.addAttribute("bebidas", (bebidas));
        model.addAttribute("acompaniamientos", (acompaniamientos));
        model.addAttribute("comidasRapidas", (comidasRapidas));
        model.addAttribute("idMenuSeleccionado", (idMenuSeleccionado));
        return "/index";
    }

    @GetMapping("/seleccionarProducto/{idProducto}")
    public String seleccionarMenu(@PathVariable("idProducto") int idMenu, Model model) {
        if (carritoDeCompraService.getCompra() != null) {
            compraService.iniciarCompra();
        }

        return "/index";
    }

    @GetMapping("/seleccionarProductoPorMenu/{idMenuSeleccionado}/detail/{idProducto}")
    public String seleccionarProductoPorMenu(@PathVariable("idMenuSeleccionado") int idMenuSeleccionado, @PathVariable("idProducto") int idProducto, Model model) {

        return "/index";
    }

}
