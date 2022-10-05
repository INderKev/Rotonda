package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.entity.Administrador;
import com.rolosdev.seminarioproject.entity.Cliente;
import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.entity.entityHelp.Login;
import com.rolosdev.seminarioproject.repository.IAdministradorRepository;
import com.rolosdev.seminarioproject.repository.IClienteRepository;
import com.rolosdev.seminarioproject.repository.IRestauranteRepository;
import com.rolosdev.seminarioproject.services.interfacesServices.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("loginService")
@Transactional
public class LoginService implements ILoginService {

    @Autowired
    @Qualifier("administradorRepository")
    private IAdministradorRepository administradorRepository;

    @Autowired
    @Qualifier("clienteRepository")
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("restauranteRepository")
    private IRestauranteRepository restauranteRepository;

    public String verificarDatos(Login login){
        return null;
    }
    public Cliente obtenerCliente(Login login){
        return null;
    }
    public Administrador obtenerAdministrador(Login login){
        return null;
    }
    public Restaurante obtenerRestaurante(Login login){
        return null;
    }

}
