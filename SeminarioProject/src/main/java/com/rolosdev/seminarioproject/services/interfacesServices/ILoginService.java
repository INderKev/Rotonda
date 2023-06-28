package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.Administrador;
import com.rolosdev.seminarioproject.entity.Cliente;
import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;


public interface ILoginService {

    public String verificarDatos(Login login);
    public Cliente obtenerCliente(Login login);
    public Administrador obtenerAdministrador(Login login);
    public Restaurante obtenerRestaurante(Login login);

}
