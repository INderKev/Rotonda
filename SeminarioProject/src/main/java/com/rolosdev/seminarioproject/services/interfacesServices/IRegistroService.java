package com.rolosdev.seminarioproject.services.interfacesServices;

import com.rolosdev.seminarioproject.entity.Administrador;
import com.rolosdev.seminarioproject.entity.Cliente;
import com.rolosdev.seminarioproject.entity.Restaurante;

public interface IRegistroService {

    public String registrarCliente(Cliente cliente);
    public String registrarAdministrador(Administrador administrador);
    public String registrarRestaurante(Restaurante restaurante);

}
