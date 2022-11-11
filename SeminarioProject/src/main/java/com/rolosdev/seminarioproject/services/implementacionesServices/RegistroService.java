package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.entity.Administrador;
import com.rolosdev.seminarioproject.entity.Cliente;
import com.rolosdev.seminarioproject.entity.Restaurante;
import com.rolosdev.seminarioproject.repository.IAdministradorRepository;
import com.rolosdev.seminarioproject.repository.IClienteRepository;
import com.rolosdev.seminarioproject.repository.IRestauranteRepository;
import com.rolosdev.seminarioproject.services.interfacesServices.IRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("registroService")
@Transactional
public class RegistroService implements IRegistroService {

    @Autowired
    @Qualifier("administradorRepository")
    private IAdministradorRepository administradorRepository;

    @Autowired
    @Qualifier("clienteRepository")
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("restauranteRepository")
    private IRestauranteRepository restauranteRepository;
    @Override
    public String registrarCliente(Cliente cliente) {
        if (clienteRepository.verificarExistencia(cliente.getCorreo()) == null) {
            if (clienteRepository.verificarExistenciaIDcliente(cliente.getIdCliente()) == null) {
                clienteRepository.save(cliente);
                return "OK";
            }
            return "El número de identificación " + cliente.getIdCliente() + " ya existe, verifique los datos";
        }
        return "El correo " + cliente.getCorreo() + " Ya existe, verifique los datos";
    }
    @Override
    public String registrarAdministrador(Administrador administrador) {
        if (administradorRepository.verificarExistencia(administrador.getUserAdministrador()) == null) {
            administrador.setAdministradorId(administradorRepository.obtenerUltimoId().getAdministradorId() + 1);
            administradorRepository.save(administrador);
            return "OK";
        }
        return "El usuario " + administrador.getUserAdministrador() + " Ya existe, verifique los datos";
    }
    @Override
    public String registrarRestaurante(Restaurante restaurante) {
        if (restauranteRepository.verificarExistencia(restaurante.getUser()) == null) {
            restaurante.setIdRestaurante(restauranteRepository.obtenerUltimoId().getIdRestaurante() + 1);
            restauranteRepository.save(restaurante);
            return "OK";
        }
        return "El usuario " + restaurante.getIdRestaurante() + " Ya existe, verifique los datos";
    }
}
