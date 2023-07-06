package com.rolosdev.seminarioproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TarjetasClienteId implements Serializable {

    @Column(name = "IDCLIENTE")
    private int idCliente;
    
    @Column(name = "NUMTARJETA")
    private String numTarjeta;

    public TarjetasClienteId(){}

    public TarjetasClienteId(int idCliente, String numTarjeta) {
        this.idCliente = idCliente;
        this.numTarjeta = numTarjeta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idCliente;
        result = prime * result + ((numTarjeta == null) ? 0 : numTarjeta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TarjetasClienteId other = (TarjetasClienteId) obj;
        if (idCliente != other.idCliente)
            return false;
        if (numTarjeta == null) {
            if (other.numTarjeta != null)
                return false;
        } else if (!numTarjeta.equals(other.numTarjeta))
            return false;
        return true;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    
}