package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.entity.entityHelp.CaptchaResponse;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;
import com.rolosdev.seminarioproject.services.CarritoDeCompraService;
import com.rolosdev.seminarioproject.services.CompraService;
import com.rolosdev.seminarioproject.services.ConsultaService;
import com.rolosdev.seminarioproject.services.LoginService;
import com.rolosdev.seminarioproject.services.UsuarioLogueadoService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @Autowired
    @Qualifier("compraService")
    private CompraService compraService;

    @Autowired
    @Qualifier("consultaService")
    private ConsultaService consultaService;

    @Value("${recaptcha.secret}")
    private String recaptchasecret;
    @Value("${recaptcha.url}")
    private String recaptchaurl;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    };
    @Autowired
    private RestTemplate restTemplate;

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
    public String loguearse(@Validated Login login, BindingResult bindingResult,HttpServletRequest request, Model model, SessionStatus status) {
        login.setTipoUsuario(loginService.verificarDatos(login));
        //verificar el captcha desde el controlador tambien :n
        String captcha=request.getParameter("g-recaptcha-response");
        System.out.print(verificarcaptcha(captcha));
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
                model.addAttribute("productos", consultaService.obtenerProductosDelRestaurante(restaurante.getIdRestaurante()));
                model.addAttribute("menus", consultaService.obtenerMenusDelRestaurante(restaurante.getIdRestaurante()));
                model.addAttribute("clasificaciones", consultaService.obtenerClasificaciones());
                model.addAttribute("restaurante", UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
                model.addAttribute("producto", new Producto());
                model.addAttribute("menu", new Menu());
                model.addAttribute("productoAConsultar", new Producto());
                model.addAttribute("menuAConsultar", new Menu());
                model.addAttribute("stock",restaurante.getStocks());
                model.addAttribute("ingredientes",consultaService.obteneringredientescomplementorestaurante(restaurante.getIdRestaurante()));
                model.addAttribute("newstock",new Stock());
                return "/dashboard-restaurante";

            default:
                model.addAttribute("login", new Login());
                model.addAttribute("error", "Nombre de usuario o contraseña incorrectos.");
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
                    model.addAttribute("ingredientes",consultaService.obteneringredientescomplementorestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante().getIdRestaurante()));
                    Stock newstock=new Stock();
                    newstock.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
                    model.addAttribute("newstock",newstock);
                    
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
    private Boolean verificarcaptcha(String gRecaptchaResponse){
        HttpHeaders Headers=new HttpHeaders();
        Headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> map=new LinkedMultiValueMap<>();
        System.out.println(recaptchaurl);
        map.add("secret",recaptchasecret);
        map.add("response",gRecaptchaResponse);
        HttpEntity<MultiValueMap<String,String>> request= new HttpEntity<>(map,Headers);

        CaptchaResponse response=restTemplate.postForObject(recaptchaurl,request,CaptchaResponse.class);
        //ResponseEntity<String> response2=restTemplate.postForEntity(recaptchaurl, request, String.class);

        if(response == null)
            return false;

        return response.isSucess();
        
    }

}
