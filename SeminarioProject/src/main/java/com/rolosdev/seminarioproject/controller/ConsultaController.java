package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.entity.Producto;
import com.rolosdev.seminarioproject.entity.Stock;
import com.rolosdev.seminarioproject.services.ConsultaService;
import com.rolosdev.seminarioproject.services.UsuarioLogueadoService;

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
        model.addAttribute("ingredienteAConsultar", new Ingrediente());
        model.addAttribute("stock",UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getStocks() );
        model.addAttribute("productoAConsultar", new Producto());
        model.addAttribute("menuAConsultar", new Menu());
        model.addAttribute("ingredientes", consultaService.obteneringredientescomplementorestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        Stock newstock = new Stock();
        newstock.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        model.addAttribute("newstock", newstock);
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
        model.addAttribute("ingredienteAConsultar", new Ingrediente());
        model.addAttribute("stock",UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getStocks() );
        model.addAttribute("productoAConsultar", new Producto());
        model.addAttribute("menuAConsultar", new Menu());
        model.addAttribute("ingredientes", consultaService.obteneringredientescomplementorestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        Stock newstock = new Stock();
        newstock.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        model.addAttribute("newstock", newstock);
        return "/dashboard-restaurante";
    }

    @PostMapping("/ingredientePorId")
    public String consultarMenuPorId(@Validated Ingrediente ingredienteBuscado, BindingResult bindingResult, Model model, SessionStatus status) {
        ArrayList<Stock> stock = new ArrayList<>();
        List<Stock> stockAux = UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getStocks();
        for (Stock s : stockAux)
            if (s.getIngrediente().getNombre().toLowerCase().equals(ingredienteBuscado.getNombre().toLowerCase())) {
                stock.add(s);
                break;
            }

        model.addAttribute("productos", consultaService.obtenerProductosDelRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        model.addAttribute("menus", consultaService.obtenerMenusDelRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        model.addAttribute("clasificaciones", consultaService.obtenerClasificaciones());
        model.addAttribute("restaurante", UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        model.addAttribute("producto", new Producto());
        model.addAttribute("menu", new Menu());
        model.addAttribute("ingredienteAConsultar", new Ingrediente());
        model.addAttribute("stock", stock);
        model.addAttribute("productoAConsultar", new Producto());
        model.addAttribute("menuAConsultar", new Menu());
        model.addAttribute("ingredientes", consultaService.obteneringredientescomplementorestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
        Stock newstock = new Stock();
        newstock.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        model.addAttribute("newstock", newstock);
        return "/dashboard-restaurante";
    }

    //Metodo que redirecciona al formulario de modificacion de ingredientes para un restaurante
    @GetMapping("/modificar/{idStock}")
    public String formularioDeIngrediente(Model model, @PathVariable("idStock") String idStock) {
        Stock stockseleccionado = consultaService.obtenerStock(Integer.valueOf(idStock));
        model.addAttribute("stock", stockseleccionado);
        model.addAttribute("ingrediente", stockseleccionado.getIngrediente());
        model.addAttribute("restaurante", stockseleccionado.getRestaurante());
        return "/modificar-ingrediente";
    }

    @PostMapping("/listarIngredientes")
    public String listarIngredientes(ModelMap modelo, @RequestParam (name = "idrestaurante" , required = true) int idRestaurante) {
        List<Stock> listaStock = consultaService.obtenerStockPorRestaurante(idRestaurante);
        modelo.addAttribute("listaStock", listaStock);
        return "/ingrediente-cantidad";
    }

    @GetMapping("/eliminarIngredienteAdm/{nombre}")
    public String elimarIngrediente(@PathVariable (name = "nombre") String nombre , ModelMap modelo){
        System.out.println(nombre);
        consultaService.eliminarIngrediente(nombre);
        return "redirect:/home";
    }
    
    @GetMapping("/eliminarIngredienteAdmLista")
    public String elimarIngredienteLista(@RequestParam (name = "value") String nombre , ModelMap modelo){
        consultaService.eliminarIngrediente(nombre);
        return "redirect:/home";
    }
     
    @PostMapping("/modificarDescripcionIngrediente")
    public String modificarDescripcionIngrediente(Ingrediente ingrediente, ModelMap modelo){
        consultaService.editarDescripcionIngrediente(ingrediente.getNombre(), ingrediente.getDescripcion());
        return "redirect:/home";
    }

    @GetMapping("/mostrarDescripcionIngrediente/{nombre}")
    public String mostrarDescripcionIngrediente(@PathVariable (name = "nombre") String nombre , ModelMap modelo) {
        Ingrediente ingrediente = consultaService.obtenerIngredientePorNombre(nombre);
        modelo.addAttribute("ingrediente", ingrediente);
        return "/modificar-descripcion";
    }
}
 