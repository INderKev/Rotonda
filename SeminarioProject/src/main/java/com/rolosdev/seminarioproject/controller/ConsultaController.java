package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;
import com.rolosdev.seminarioproject.services.implementacionesServices.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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




}
