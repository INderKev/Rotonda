package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;
import com.rolosdev.seminarioproject.services.implementacionesServices.CarritoDeCompraService;
import com.rolosdev.seminarioproject.services.implementacionesServices.CompraService;
import com.rolosdev.seminarioproject.services.implementacionesServices.ConsultaService;
import com.rolosdev.seminarioproject.services.implementacionesServices.UsuarioLogueadoService;
import com.rolosdev.seminarioproject.services.interfacesServices.ILoginService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    private ILoginService loginService;

    @Autowired
    @Qualifier("compraService")
    private CompraService compraService;

    @Autowired
    @Qualifier("consultaService")
    private ConsultaService consultaService;

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("login", new Login());
        return "/login";
    }
    @GetMapping("/seleccionarRol")
    public String getSeleccionarRol(Model model) {
        return "/seleccionar_rol";
    }

    @GetMapping("/registro-administrador")
    public String getRegistro(Model model) {
        model.addAttribute("administrador", new Administrador());
        return "/registro-administrador";
    }

    @GetMapping("/registro-cliente")
    public String getRegistroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "/registro-cliente";
    }

    @GetMapping("/registro-restaurante")
    public String getRegistroRestaurante(Model model) {
        model.addAttribute("restaurante", new Restaurante());
        model.addAttribute("especialidades", consultaService.obtenerEspecialidades());
        return "/registro-restaurante";
    }

    @PostMapping("/loguearse")
    public String loguearse(@Validated Login login, BindingResult bindingResult, Model model, SessionStatus status) {
        login.setTipoUsuario(loginService.verificarDatos(login));
        switch (login.getTipoUsuario()) {
            case "Cliente":
                Cliente cliente = loginService.obtenerCliente(login);
                UsuarioLogueadoService.getUsuarioLogueadoService().abrirSesionCliente("Cliente", cliente);
                UsuarioLogueadoService.getUsuarioLogueadoService().setCliente(cliente);
                model.addAttribute("restaurantes", consultaService.obtenerRestaurantes());
                model.addAttribute("especialidades", consultaService.obtenerEspecialidades());
                return "/listarRestaurantes";

            case "Administrador":
                Administrador administrador = loginService.obtenerAdministrador(login);
                UsuarioLogueadoService.getUsuarioLogueadoService().setAdministrador(administrador);
                UsuarioLogueadoService.getUsuarioLogueadoService().abrirSesionAdministrador("Administrador", administrador);
                model.addAttribute("ingrediente", new Ingrediente());
                ArrayList<Restaurante> restaurantes = consultaService.obtenerRestaurantes();
                model.addAttribute("restaurantes", restaurantes);
                return "/registro-ingrediente";

            case "Restaurante":
                Restaurante restaurante = loginService.obtenerRestaurante(login);
                UsuarioLogueadoService.getUsuarioLogueadoService().abrirSesionRestaurante("Restaurante", restaurante);
                UsuarioLogueadoService.getUsuarioLogueadoService().setRestaurante(restaurante);
                //anadido
                   

                model.addAttribute("productos", consultaService.obtenerProductosDelRestaurante(restaurante.getIdRestaurante()));
                model.addAttribute("menus", consultaService.obtenerMenusDelRestaurante(restaurante.getIdRestaurante()));
                model.addAttribute("clasificaciones", consultaService.obtenerClasificaciones());
                model.addAttribute("restaurante", UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
                model.addAttribute("producto", new Producto());
                model.addAttribute("menu", new Menu());
                model.addAttribute("productoAConsultar", new Producto());
                model.addAttribute("menuAConsultar", new Menu());
                model.addAttribute("stock",restaurante.getStocks());
                
                return "/dashboard-restaurante";

            default:
                model.addAttribute("login", new Login());
                model.addAttribute("error", "El usuario no fue encontrado");
                return "/login";
        }
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        if (UsuarioLogueadoService.getUsuarioLogueadoService().getTipoUsuario() != null){
            switch (UsuarioLogueadoService.getUsuarioLogueadoService().getTipoUsuario()) {
                case "Cliente":
                    model.addAttribute("restaurantes", consultaService.obtenerRestaurantes());
                    model.addAttribute("especialidades", consultaService.obtenerEspecialidades());
                    return "/listarRestaurantes";
                case "Administrador":
                    model.addAttribute("ingrediente", new Ingrediente());
                    return "/registro-ingrediente";
                case "Restaurante":
                    UsuarioLogueadoService.getUsuarioLogueadoService().setRestaurante(consultaService.obtenerRestauranteById(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
                    model.addAttribute("productos", consultaService.obtenerProductosDelRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
                    model.addAttribute("menus", consultaService.obtenerMenusDelRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
                    model.addAttribute("clasificaciones", consultaService.obtenerClasificaciones());
                    model.addAttribute("restaurante", UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
                    model.addAttribute("producto", new Producto());
                    model.addAttribute("menu", new Menu());
                    model.addAttribute("productoAConsultar", new Producto());
                    model.addAttribute("menuAConsultar", new Menu());
                    model.addAttribute("stock",UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getStocks() );
                    
                    return "/dashboard-restaurante";
                default:
                    return "/index";
            }
        }
        return "/index";
    }

    @GetMapping("/cerrarSesion")
    public String cerrarSesion(Model model) {
        if (CarritoDeCompraService.getCarritoDeCompraService().getCompra() != null) {
            compraService.cancelarCompra();
        }
        UsuarioLogueadoService.getUsuarioLogueadoService().cerrarSesion();
        return "/index";
    }

}
