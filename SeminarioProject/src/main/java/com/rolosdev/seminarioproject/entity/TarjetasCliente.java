package com.rolosdev.seminarioproject.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TARJETAS_CLIENTE")
public class TarjetasCliente {
    
    @EmbeddedId
    private TarjetasClienteId id;

    public TarjetasCliente(TarjetasClienteId id) {
        this.id = id;
    }

    public TarjetasCliente() {}
    
    public TarjetasClienteId getId() {
        return id;
    }

    public void setId(TarjetasClienteId id) {
        this.id = id;
    }
    
}
