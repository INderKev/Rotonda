package com.rolosdev.seminarioproject.controller;

import com.rolosdev.seminarioproject.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;


}
