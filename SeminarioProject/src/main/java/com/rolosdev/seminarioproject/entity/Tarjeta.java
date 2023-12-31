package com.rolosdev.seminarioproject.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
@Table(name = "TARJETA")
public class Tarjeta {

    @Id
    @Pattern(regexp = "^(\\d{4})[ -]?((\\d{4}[ -]?){3}|(\\d{6}[ -]?\\d{5}))$")
    @Column(name = "NUMTARJETA")
    private String numTarjeta;

    @Pattern(regexp = "^\\d{3}$")
    @Column(name = "PIN")
    private String pin;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "FECHA_CADUCIDAD")
    private Date fechaCaducidad;

    public int primerNumero() {
        String primerCaracter = String.valueOf(this.numTarjeta.charAt(0));
        return Integer.parseInt(primerCaracter);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numTarjeta == null) ? 0 : numTarjeta.hashCode());
        result = prime * result + ((pin == null) ? 0 : pin.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((fechaCaducidad == null) ? 0 : fechaCaducidad.hashCode());
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
        Tarjeta other = (Tarjeta) obj;
        if (numTarjeta == null) {
            if (other.numTarjeta != null)
                return false;
        } else if (!numTarjeta.equals(other.numTarjeta))
            return false;
        if (pin == null) {
            if (other.pin != null)
                return false;
        } else if (!pin.equals(other.pin))
            return false;
        if (fechaCaducidad == null) {
            if (other.fechaCaducidad != null)
                return false;
        } else if (!fechaCaducidad.equals(other.fechaCaducidad))
            return false;
        return true;
    }

}
