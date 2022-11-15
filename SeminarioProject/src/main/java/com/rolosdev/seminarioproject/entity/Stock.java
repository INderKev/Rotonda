package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @Column(name = "IDSTOCK", nullable = false)
    private int idStock;
    @Column(name = "IDINGREDIENTE", nullable = false)
    private int idIngrediente;

    @Column(name = "IDRESTAURANTE", nullable = false)
    private int idRestaurante;
    @Column(name = "CANTIDAD_STOCK", nullable = false)
    private double cantidadStock;

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public double getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(double cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
}
