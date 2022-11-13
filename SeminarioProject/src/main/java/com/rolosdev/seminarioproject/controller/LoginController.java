package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.Administrador;
import com.rolosdev.seminarioproject.entity.Cliente;
import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;
import com.rolosdev.seminarioproject.services.implementacionesServices.UsuarioLogueadoService;
import com.rolosdev.seminarioproject.services.interfacesServices.ILoginService;
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

    @GetMapping("/login")
    public String getIndex(Model model) {
        model.addAttribute("login", new Login());
        return "/login";
    }

    @PostMapping("/loguearse")
    public String loguearse(@Validated Login login, BindingResult bindingResult, Model model, SessionStatus statu) {
        login.setTipoUsuario(loginService.verificarDatos(login));
        switch (login.getTipoUsuario()) {
            case "Cliente":
                Cliente cliente = loginService.obtenerCliente(login);
                UsuarioLogueadoService.getUsuarioLogueadoService().abrirSesionCliente("Cliente", cliente);
                return "/index";
            case "Administrador":
                Administrador administrador = loginService.obtenerAdministrador(login);
                UsuarioLogueadoService.getUsuarioLogueadoService().abrirSesionAdministrador("Administrador", administrador);
                return "/index";
            case "Restaurante":
                Restaurante restaurante = loginService.obtenerRestaurante(login);
                UsuarioLogueadoService.getUsuarioLogueadoService().abrirSesionRestaurante("Restaurante", restaurante);
                return "/index";
            default:
                model.addAttribute("login", new Login());
                model.addAttribute("Mensaje", "El usuario no fue encontrado");
                return "/login";
        }
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        switch (UsuarioLogueadoService.getUsuarioLogueadoService().getTipoUsuario()) {
            case "Cliente":
                return "/index";
            case "Administrador":
                return "/index";
            case "Restaurante":
                return "/index";
            default:
                return "/index";
        }
    }

    @GetMapping("/cerrarSesion")
    public String cerrarSesion(Model model) {
        UsuarioLogueadoService.getUsuarioLogueadoService().cerrarSesion();
        return "/index";
    }

}
