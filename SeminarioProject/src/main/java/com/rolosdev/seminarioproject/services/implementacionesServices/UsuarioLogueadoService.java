package com.rolosdev.seminarioproject.services.implementacionesServices;

public class UsuarioLogueadoService {

    static public  UsuarioLogueadoService usuarioLogueadoService;

    private UsuarioLogueadoService() {
    }

    static public UsuarioLogueadoService getUsuarioLogueadoService() {
        if (usuarioLogueadoService == null) {
            usuarioLogueadoService = new UsuarioLogueadoService();
        }
        return usuarioLogueadoService;
    }

}
