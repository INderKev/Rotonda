package com.rolosdev.seminarioproject.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "COMPRA")
public class Compra {

    @Id
    @Column(name = "IDCOMPRA", nullable = false)
    private int idCompra;
    @Column(name = "NUMTARJETA", nullable = true)
    private String numTarteta;
    @Column(name = "PAGAEFECTIVO", nullable = false)
    private boolean pagaEfectivo;
    @Column(name = "TOTAL", nullable = false)
    private double total;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
    @JoinColumn(name = "IDCLIENTE", nullable = false)
    Cliente cliente;

}
