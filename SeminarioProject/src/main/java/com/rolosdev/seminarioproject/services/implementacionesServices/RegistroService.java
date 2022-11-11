package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.repository.*;
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

    @Autowired
    @Qualifier("ingredienteRepository")
    private IIngredienteRepository ingredienteRepository;

    @Autowired
    @Qualifier("productoRepository")
    private IProductoRepository productoRepository;

    @Autowired
    @Qualifier("menuRepository")
    private IMenuRepository menuRepository;

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

    @Override
    public String registrarIngrediente(Ingrediente ingrediente) {
        if (ingredienteRepository.verificarExistencia(ingrediente.getNombre()) == null) {
            ingrediente.setIdIngrediente(ingredienteRepository.obtenerUltimoId().getIdIngrediente() + 1);
            ingredienteRepository.save(ingrediente);
            return "OK";
        }
        return "El ingrediente " + ingrediente.getNombre() + " ya existe.";
    }

    @Override
    public String registrarProducto(Producto producto) {
        if (productoRepository.verificarExistencia(producto.getIdRestaurante(), producto.getNombre()) == null) {
            producto.setIdProducto(productoRepository.obtenerUltimoId().getIdProducto() + 1);
            productoRepository.save(producto);
            return "OK";
        }
        return "El Producto " + producto.getNombre() + " ya existe.";
    }

    @Override
    public String registrarMenu(Menu menu) {
        if (menuRepository.verificarExistencia(menu.getIdRestaurante(), menu.getNombre()) == null) {
            menu.setIdMenu(menuRepository.obtenerUltimoId().getIdMenu() + 1);
            menuRepository.save(menu);
            return "OK";
        }
        return "El Menu " + menu.getNombre() + " ya existe.";
    }


}
