package com.rolosdev.seminarioproject.services;

import com.rolosdev.seminarioproject.repository.IAdministradorRepository;
import com.rolosdev.seminarioproject.repository.IClienteRepository;
import com.rolosdev.seminarioproject.repository.IRestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("loginService")
@Transactional
public class LoginService {

    @Autowired
    @Qualifier("administradorRepository")
    private IAdministradorRepository administradorRepository;

    @Autowired
    @Qualifier("clienteRepository")
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("restauranteRepository")
    private IRestauranteRepository restauranteRepository;

}
