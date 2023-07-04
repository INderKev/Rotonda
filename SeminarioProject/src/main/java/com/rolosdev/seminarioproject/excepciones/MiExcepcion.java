package com.rolosdev.seminarioproject.excepciones;

//Clase encargada de generar excepciones personalizadas
public class MiExcepcion extends Exception {
    public MiExcepcion(String msg){
        super(msg);
    }
}
