package com.rolosdev.seminarioproject.entity.entityHelp;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Login {

    @Id
    private int id;
    private String usuario;
    private String pass;
    private String tipoUsuario;

}
