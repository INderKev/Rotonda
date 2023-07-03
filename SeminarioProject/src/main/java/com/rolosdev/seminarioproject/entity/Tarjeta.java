package com.rolosdev.seminarioproject.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TARJETA")
public class Tarjeta {
    @Id
    @Column(name = "NUMTARJETA")
    private String numTarjeta;
    @Column(name = "PIN")
    private Integer pin;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FECHA_CADUCIDAD")
    private Date fechaCaducidad;

    
    public String getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    public Integer getPin() {
        return pin;
    }
    public void setPin(Integer pin) {
        this.pin = pin;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    public int primerNumero() {
        String primerCaracter = String.valueOf(this.numTarjeta.charAt(0));
        return Integer.parseInt(primerCaracter);
    }




    
}
