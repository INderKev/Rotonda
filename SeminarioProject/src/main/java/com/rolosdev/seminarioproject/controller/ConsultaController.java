package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.entity.Stock;
import com.rolosdev.seminarioproject.services.implementacionesServices.ConsultaService;
import com.rolosdev.seminarioproject.services.implementacionesServices.UsuarioLogueadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping
public class ConsultaController {
    
    @Autowired
    @Qualifier("consultaService")
    private ConsultaService consultaService;

    @GetMapping("/mostrarRestaurantes")
    public String mostrarRestaurantes(Model model) {
        model.addAttribute("restaurantes", consultaService.obtenerRestaurantes());
        return "/index";
    }

    @PostMapping("/productoPorId")
    public String consultarProductoPorId(@Validated Producto productoBuscado, BindingResult bindingResult, Model model, SessionStatus status) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(consultaService.obtenerProductoPorId(productoBuscado.getIdProducto()));
        model.addAttribute("productos", productos);
        model.addAttribute("menus", consultaService.obtenerMenusDelRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        model.addAttribute("clasificaciones", consultaService.obtenerClasificaciones());
        model.addAttribute("restaurante", UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        model.addAttribute("producto", new Producto());
        model.addAttribute("menu", new Menu());
        model.addAttribute("productoAConsultar", new Producto());
        model.addAttribute("menuAConsultar", new Menu());
        System.out.println("MIERDA");
        return "/dashboard-restaurante";
    }

    @PostMapping("/menuPorId")
    public String consultarMenuPorId(@Validated Menu menuBuscado, BindingResult bindingResult, Model model, SessionStatus status) {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(consultaService.obtenerMenuPorId(menuBuscado.getIdMenu()));
        model.addAttribute("productos", consultaService.obtenerProductosDelRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        model.addAttribute("menus", menus);
        model.addAttribute("clasificaciones", consultaService.obtenerClasificaciones());
        model.addAttribute("restaurante", UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        model.addAttribute("producto", new Producto());
        model.addAttribute("menu", new Menu());
        model.addAttribute("productoAConsultar", new Producto());
        model.addAttribute("menuAConsultar", new Menu());
        return "/dashboard-restaurante";
    }
    //Metodo que redirecciona al formulario de modificacion de ingredientes para un restaurante
    @GetMapping("/modificar/{idStock}")
    public String formulariodeingrediente(Model model,@PathVariable("idStock") String idStock) {
       Stock stockseleccionado=consultaService.obtenerStock(Integer.valueOf(idStock));
      /*  System.out.println(stockseleccionado.getIdStock()+"pito");
        System.out.println(stockseleccionado.getIdIngrediente()+"pito");
        System.out.println(stockseleccionado.getCantidadStock());
        System.out.println(stockseleccionado.getIdRestaurante()+"pito");
        System.out.println(stockseleccionado.getIdIngrediente()+"pito");*/
        model.addAttribute("stock", stockseleccionado);
        return "/modificar-ingrediente";
    }
    

    @PostMapping("/listarIngredientes")
    public String listarIngredientes(ModelMap modelo, @RequestParam (name = "idrestaurante" , required = true) int idRestaurante) {
        List<Stock> listaStock = consultaService.obtenerStockPorRestaurante(idRestaurante);
        modelo.addAttribute("listaStock", listaStock);
        return "/ingrediente-cantidad";
    }

}
