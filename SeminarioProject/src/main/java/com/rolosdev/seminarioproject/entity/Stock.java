package com.rolosdev.seminarioproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Entity
@Data
@Table(name = "STOCK")
public class Stock {

    @Id
    @Column(name = "IDSTOCK", nullable = false)
    private int idStock;
    @Column(name = "CANTIDAD_STOCK", nullable = false)
    @PositiveOrZero(message="La cantidad no puede ser menor a 0")
    @NotNull(message="La cantidad no puede ser menor a 0")
    private double cantidadStock;

    @ManyToOne(fetch = FetchType.LAZY , targetEntity = Ingrediente.class )
    @JoinColumn(name = "IDINGREDIENTE")
    private Ingrediente ingrediente;

    @ManyToOne (fetch = FetchType.LAZY, targetEntity = Restaurante.class)
    @JoinColumn(name = "IDRESTAURANTE")
    private Restaurante restaurante;
    
}
