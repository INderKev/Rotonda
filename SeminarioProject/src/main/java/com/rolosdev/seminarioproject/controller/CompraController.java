package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.Menu;
import com.rolosdev.seminarioproject.services.implementacionesServices.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping
public class CompraController {

    @Autowired
    @Qualifier("compraService")
    private CompraService compraService;

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

}
