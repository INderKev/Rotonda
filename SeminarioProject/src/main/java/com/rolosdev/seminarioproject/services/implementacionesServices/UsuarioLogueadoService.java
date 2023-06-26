package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.entity.Administrador;
import com.rolosdev.seminarioproject.entity.Cliente;
import com.rolosdev.seminarioproject.entity.Restaurante;

public class UsuarioLogueadoService {


    private String tipoUsuario;
    private Administrador administrador;
    private Cliente cliente;
    private Restaurante restaurante;

    public UsuarioLogueadoService() {
        
    }

    public void abrirSesionAdministrador(String tipoUsuario, Administrador usuario) {
        this.tipoUsuario = tipoUsuario;
        this.administrador = usuario;
    }

    public void abrirSesionCliente(String tipoUsuario, Cliente usuario) {
        this.tipoUsuario = tipoUsuario;
        this.cliente = usuario;
    }

    public void abrirSesionRestaurante(String tipoUsuario, Restaurante usuario) {
        this.tipoUsuario = tipoUsuario;
        this.restaurante = usuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void cerrarSesion() {
        tipoUsuario = null;
        administrador = null;
        cliente = null;
        restaurante = null;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }


    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
