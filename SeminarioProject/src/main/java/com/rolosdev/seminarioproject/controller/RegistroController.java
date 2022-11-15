package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;
import com.rolosdev.seminarioproject.services.interfacesServices.IRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class RegistroController {

    @Autowired
    @Qualifier("registroService")
    private IRegistroService registroService;

    @GetMapping("/pruebaRegistro")
    public String getIndex(Model model) {
        /*Administrador administrador = new Administrador();
        administrador.setUserAdministrador("Satán");
        administrador.setPassword("asd123");
        System.out.println(registroService.registrarAdministrador(administrador));*/

        /*Restaurante restaurante = new Restaurante();
        restaurante.setPassword("asd123");
        restaurante.setDireccion("algo");
        restaurante.setNombre("añañai");
        restaurante.setTelefono("123456789");
        restaurante.setUser("rolitospte");
        restaurante.setIdEspecialidad(2);
        System.out.println(registroService.registrarRestaurante(restaurante));*/

        /*Cliente cliente = new Cliente();
        cliente.setIdCliente(987845);
        cliente.setDireccion("a");
        cliente.setPassword("asd123");
        cliente.setCorreo("mpgc2@correo.com");
        cliente.setTelefono(123456789);
        cliente.setPrimerNombre("asdfa");
        cliente.setPrimerApellido("asdf");
        System.out.println(registroService.registrarCliente(cliente));*/

        /*Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Gaseosa Ponymalta");
        ingrediente.setTipoUnidad("Unidad");
        System.out.println(registroService.registrarIngrediente(ingrediente));*/

        /*Producto producto = new Producto();
        producto.setIdRestaurante(1);
        producto.setNombre("Ponymalta");
        producto.setPrecio(3000);
        producto.setIdClasificacion(4);
        producto.setImagenProducto("asdlkfjalskdfj");
        System.out.println(registroService.registrarProducto(producto));*/

        /*Menu menu = new Menu();
        menu.setImagenMenu("otra imagen");
        menu.setIdRestaurante(1);
        menu.setNombre("Combo Hamburguesa re gonorrea");
        menu.setPrecio(21500.15);
        System.out.println(registroService.registrarMenu(menu));*/

        /*ProductoIngrediente productoIngrediente = new ProductoIngrediente();
        productoIngrediente.setIdProducto(26);
        productoIngrediente.setIdIngrediente(37);
        productoIngrediente.setCantidad(1);
        productoIngrediente.setEditable(false);
        System.out.println(registroService.registrarProductoIngrediente(productoIngrediente));*/

        /*Seleccion seleccion = new Seleccion();
        seleccion.setIdMenu(8);
        seleccion.setIdClasificacion(4);
        seleccion.setPrecioBajo(3000);
        seleccion.setPrecioAlto(3000);
        System.out.println(registroService.registrarSeleccion(seleccion));*/

        registroService.pruebas();

        return "/index";
    }

    @PostMapping("/registrarCliente")
    public String registrarCliente(HttpServletResponse response, @Validated Cliente cliente, Model model){
        String resultado = registroService.registrarCliente(cliente);
        if (!resultado.equals("OK")){
            model.addAttribute("Mensaje", resultado);
            return "/registro-cliente";
        }
        return "/index";
    }

    @PostMapping("/registrarAdministrador")
    public String registrarAdministrador(HttpServletResponse response, @Validated Administrador administrador, Model model){
        String resultado = registroService.registrarAdministrador(administrador);
        if (!resultado.equals("OK")){
            model.addAttribute("Mensaje", resultado);
            return "/registro-administrador";
        }
        return "/index";
    }

    @PostMapping("/registrarRestaurante")
    public String registrarRestaurante(HttpServletResponse response, @Validated Restaurante restaurante, Model model){
        String resultado = registroService.registrarRestaurante(restaurante);
        if (!resultado.equals("OK")){
            model.addAttribute("Mensaje", resultado);
            return "/registro-administrador";
        }
        return "/index";
    }
}
