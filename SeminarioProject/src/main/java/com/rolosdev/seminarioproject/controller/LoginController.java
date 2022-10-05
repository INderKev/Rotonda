package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.entity.entityHelp.Login;
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
    public String getLogin(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "login";
    }

    @PostMapping("/loguearse")
    public String loguearse(@Validated Login login, BindingResult bindingResult, Model model, SessionStatus statu) {

        return "login";
    }

}
