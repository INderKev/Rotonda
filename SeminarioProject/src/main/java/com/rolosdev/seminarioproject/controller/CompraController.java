package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.services.interfacesServices.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CompraController {

    @Autowired
    @Qualifier("compraService")
    private ICompraService compraService;

}
