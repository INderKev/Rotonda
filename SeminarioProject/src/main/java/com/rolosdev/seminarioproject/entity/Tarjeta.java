package com.rolosdev.seminarioproject.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "TARJETA")
public class Tarjeta {

    @Id
    @Pattern(regexp = "^(\\d{4})[ -]?((\\d{4}[ -]?){3}|(\\d{6}[ -]?\\d{5}))$")
    @Column(name = "NUMTARJETA")
    private String numTarjeta;

    @Column(name = "PIN")
    private int pin;
    
    @Column(name = "TIPO")
    private String tipo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_CADUCIDAD")
    private LocalDate fechaCaducidad;

    public int primerNumero() {
        String primerCaracter = String.valueOf(this.numTarjeta.charAt(0));
        return Integer.parseInt(primerCaracter);
    }

}
