package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @Column(name = "IDCLIENTE", nullable = false)
    private int idCliente;
    @Column(name = "PRIMERNOMBRE", nullable = false)
    private String primerNombre;
    @Column(name = "SEGUNDONOMBRE", nullable = true)
    private String segundoNombre;
    @Column(name = "PRIMERAPELLIDO", nullable = false)
    private String primerApellido;
    @Column(name = "SEGUNDOAPELLIDO", nullable = true)
    private String segundoApellido;
    @Column(name = "TELEFONOCLIENTE", nullable = false)
    private int telefono;
    @Column(name = "CORREO", nullable = false)
    private String correo;
    @Column(name = "DIRECCIONCLIENTE", nullable = false)
    private String direccion;
    @Column(name = "PASSWORDCLIENTE", nullable = false)
    private String password;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
