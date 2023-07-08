package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.services.ConsultaService;
import com.rolosdev.seminarioproject.services.RegistroService;
import com.rolosdev.seminarioproject.services.UsuarioLogueadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping
public class RegistroController {

    @Autowired
    @Qualifier("registroService")
    private RegistroService registroService;

    @Autowired
    @Qualifier("consultaService")
    private ConsultaService consultaService;

    @GetMapping("/pruebaRegistro")
    public String getIndex(Model model) {
        registroService.pruebas();

        return "redirect:/home";
    }

    @PostMapping("/registrarCliente")
    public String registrarCliente(HttpServletResponse response, @Valid @Validated Cliente cliente, BindingResult result, Model model){
        if (result.hasErrors()) {
            if (result.hasFieldErrors("telefono")) {
                model.addAttribute("cliente", cliente);
                model.addAttribute("error", "Por favor, introduzca un número de teléfono válido.");
            }
            return "/registro-cliente";
        }
        String resultado = registroService.registrarCliente(cliente);
        if (!resultado.equals("OK")) {
            model.addAttribute("cliente", cliente);
            model.addAttribute("error", resultado);
            return "/registro-cliente";
        }
        model.addAttribute("success", "¡Cliente registrado con éxito!");
        return "/registro-cliente";
    }

    @GetMapping("/cambiar-contrasena-cliente")
    public String cambiarContrasenaClienteVista(Model model) {
        model.addAttribute("passwordViejo", "");
        model.addAttribute("passwordNuevo", "");
        return "/cambiar-contrasena-cliente";
    }

    @PostMapping("/cambiarContrasenaCliente")
    public String cambiarContrasenaCliente(HttpServletResponse response, String passwordViejo, String passwordNuevo, Model model) {
        Cliente cliente = UsuarioLogueadoService.getUsuarioLogueadoService().getCliente();
        if (cliente == null)
            return "redirect:/home";
        
        String mensaje = registroService.cambiarContrasenaCliente(cliente, passwordViejo, passwordNuevo);
        if (!mensaje.equals("OK")) {
            model.addAttribute("error", mensaje);
            return "/cambiar-contrasena-cliente";
        }

        return "redirect:/home";
    }

    @PostMapping("/registrarAdministrador")
    public String registrarAdministrador(HttpServletResponse response, @Validated Administrador administrador, Model model, RedirectAttributes redirAttrs) {
        String resultado = registroService.registrarAdministrador(administrador);
        if (!resultado.equals("OK")) {
            model.addAttribute("administrador", administrador);
            model.addAttribute("error", resultado);
            return "/registro-administrador";
        }
        redirAttrs.addFlashAttribute("success", "¡Administrador registrado con éxito!");
        return "redirect:/home";
    }

    @PostMapping("/registrarRestaurante")
    public String registrarRestaurante(HttpServletResponse response, @Validated Restaurante restaurante, Model model, RedirectAttributes redirAttrs) {
        String resultado = registroService.registrarRestaurante(restaurante);
        if (!resultado.equals("OK")) {
            model.addAttribute("restaurante", restaurante);
            model.addAttribute("especialidades", consultaService.obtenerEspecialidades());
            model.addAttribute("error", resultado);
            return "/registro-restaurante";
        }
        redirAttrs.addFlashAttribute("success", "¡Restaurante registrado con éxito!");
        return "redirect:/home";
    }

    @PostMapping("/registrarProducto")
    public String registrarProducto(HttpServletResponse response, @Validated Producto producto, Model model, RedirectAttributes redirAttrs) {
        producto.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        String resultado = registroService.registrarProducto(producto);
        if (!resultado.equals("OK")) {
            model.addAttribute("error", resultado);
            return "/index";
        }
        redirAttrs.addFlashAttribute("success", "¡Producto registrado con éxito!");
        return "redirect:/home";
    }

    @PostMapping("/registrarMenu")
    public String registrarMenu(HttpServletResponse response, @Validated Menu menu, Model model, RedirectAttributes redirAttrs) {
        menu.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        String resultado = registroService.registrarMenu(menu);
        if (!resultado.equals("OK")){
            model.addAttribute("error", resultado);
            return "/index";
        }
        redirAttrs.addFlashAttribute("success", "¡Menú registrado con éxito!");
        return "redirect:/home";
    }

    @PostMapping("/registarIngrediente")
    public String registarIngrediente(HttpServletResponse response, @Validated Ingrediente ingrediente, Model model, RedirectAttributes redirAttrs) {
        String resultado = registroService.registrarIngrediente(ingrediente);
        if (!resultado.equals("OK")) {
            model.addAttribute("ingrediente", ingrediente);
            model.addAttribute("error", resultado);
            return "/registro-ingrediente";
        }
        redirAttrs.addFlashAttribute("success", "¡Ingrediente registrado con éxito!");
        return "redirect:/home";
    }

    @GetMapping("/goTarjeta")
    public String goTarjeta(Model model) {
        model.addAttribute("tarjeta", new Tarjeta());
        return "/registro-tarjeta";
    }

    @PostMapping("/registrarTarjeta")
    public String registrarTarjeta(HttpServletResponse response, @Validated @Valid Tarjeta tarjeta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tarjeta", tarjeta);
            if (result.hasFieldErrors("numTarjeta"))
                model.addAttribute("error", "Por favor, ingrese un número de tarjeta AMEX, VISA o MASTERCARD válido.");
            
            if (result.hasFieldErrors("pin"))
                model.addAttribute("error", "Por favor, ingrese un pin válido.");
            
            return "/registro-tarjeta";
        }

        tarjeta.setNumTarjeta(tarjeta.getNumTarjeta().replaceAll(" ", "").replaceAll("-", ""));
        Cliente cliente = UsuarioLogueadoService.getUsuarioLogueadoService().getCliente();
        
        String resultado = registroService.registrarTarjeta(cliente, tarjeta);
        if(!resultado.equals("OK")){
            model.addAttribute("error", resultado);
            return "/registro-tarjeta";
        }

        model.addAttribute("tarjetas_cliente", consultaService.obtenerTarjetasCliente(cliente.getIdCliente()));

        model.addAttribute("success", "¡Tarjeta de crédito registrada con éxito!");
        return "/pago";
    }

    @GetMapping("/eliminarMenu/{idMenu}")
    public String eliminarMenu(@PathVariable("idMenu") int idMenu, Model model) {
        registroService.eliminarMenu(idMenu);
        return "redirect:/home";
    }

    @GetMapping("/eliminarProducto/{idProducto}")
    public String eliminarProducto(@PathVariable("idProducto") int idProducto, Model model) {
        registroService.eliminarProducto(idProducto);
        return "redirect:/home";
    }
     @GetMapping("/eliminarIngrediente/{idStock}")
    public String eliminarStock(@PathVariable("idStock") int idStock, Model model) {
        registroService.eliminarstock(idStock);
        return "redirect:/home";
    }
    
    @PostMapping("/ModificarIngrediente")
    public String registrarStock(@Valid Stock stock, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors())
            return "/modificar-ingrediente";

        registroService.modificarStockEIngrediente(stock); 
        return "redirect:/home";
    }

    @PostMapping("/registarStock")
    public String registarStock(HttpServletResponse response, @Validated Stock stock, Model model, RedirectAttributes redirAttrs) {
        stock.setRestaurante(UsuarioLogueadoService.getUsuarioLogueadoService().getRestaurante());
        registroService.modificarStockEIngrediente(stock);
      
        redirAttrs.addFlashAttribute("success", "¡Ingrediente registrado con exito!");
        return "redirect:/home";
    }

}
