package com.rolosdev.seminarioproject.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "RESTAURANTE")
public class Restaurante {

    @Id
    @Column(name = "IDRESTAURANTE", nullable = false)
    private int idRestaurante;
    @Column(name = "IDESPECIALIDAD", nullable = false)
    private int idEspecialidad;
    @Column(name = "NOM_RESTAURANTE", nullable = false)
    private String nombre;
    @Column(name = "DIRECCION", nullable = false)
    private String direccion;
    @Column(name = "TELEFONO", nullable = false)
    private String telefono;
    @Column(name = "USUARIO_RESTAURANTE", nullable = false)
    private String user;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "IMAGEN_RESTAURANTE", nullable = false)
    private String imagen;
@OneToMany(fetch=FetchType.LAZY, mappedBy="restaurante",cascade = CascadeType.ALL)
    private List<Stock> stocks;
    public List<Stock> getStocks() {
    return stocks;
}

public void setStocks(List<Stock> stocks) {
    this.stocks = stocks;
}

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
