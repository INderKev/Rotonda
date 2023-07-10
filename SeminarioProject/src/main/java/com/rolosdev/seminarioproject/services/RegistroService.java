package com.rolosdev.seminarioproject.services;

import com.rolosdev.seminarioproject.entity.*;
import com.rolosdev.seminarioproject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Random;

@Service("registroService")
@Transactional
public class RegistroService {

    @Autowired
    @Qualifier("administradorRepository")
    private IAdministradorRepository administradorRepository;

    @Autowired
    @Qualifier("clienteRepository")
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("tarjetasClienteRepository")
    private ITarjetasClienteRepository tarjetasClienteRepository;

    @Autowired
    @Qualifier("tarjetaRepository")
    private ITarjetaRepository tarjetaRepository;

    @Autowired
    @Qualifier("tipoTarjetaRepository")
    private ITipoTarjetaRepository tipoTarjetaRepository;

    @Autowired
    @Qualifier("ingredienteRepository")
    private IIngredienteRepository ingredienteRepository;

    @Autowired
    @Qualifier("menuRepository")
    private IMenuRepository menuRepository;

    @Autowired
    @Qualifier("restauranteRepository")
    private IRestauranteRepository restauranteRepository;

    @Autowired
    @Qualifier("productoRepository")
    private IProductoRepository productoRepository;

    @Autowired
    @Qualifier("productoIngredienteRepository")
    private IProductoIngredienteRepository productoIngredienteRepository;

    @Autowired
    @Qualifier("seleccionRepository")
    private ISeleccionRepository seleccionRepository;

    @Autowired
    @Qualifier("stockRepository")
    private IStockRepository stockRepository;

    public String registrarCliente(Cliente cliente) {
        if (clienteRepository.verificarExistencia(cliente.getCorreo()) == null) {
            cliente.setIdCliente(clienteRepository.obtenerUltimoId().getIdCliente() + 1);

            //Generación contraseña
            String caracteres = "@$!%*?&"
                              + "1234567890"
                              + "abcdefghijklmnopqrstuvwxyz"
                              + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            String pass = "";
            Random random = new Random();
            while (!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"))
                pass += caracteres.charAt(random.nextInt(caracteres.length()));

            cliente.setPassword(pass);

            cliente.setTelefono(
                cliente.getTelefono()
                       .replaceAll(" ", "")
                       .replaceAll("-", "")
                       .replaceAll("\\+", "")
                       .replaceAll("\\(", "")
                       .replaceAll("\\)", "")
            );

            clienteRepository.save(cliente);
            return "OK";
        }
        return "El correo " + cliente.getCorreo() + " ya existe. Verifique los datos.";
    }

    public String registrarAdministrador(Administrador administrador) {
        if (administradorRepository.verificarExistencia(administrador.getUserAdministrador()) == null) {
            administrador.setAdministradorId(administradorRepository.obtenerUltimoId().getAdministradorId() + 1);
            administradorRepository.save(administrador);
            return "OK";
        }
        return "El usuario " + administrador.getUserAdministrador() + " ya existe. Verifique los datos.";
    }
    
    public String registrarRestaurante(Restaurante restaurante) {
        if (restauranteRepository.verificarExistencia(restaurante.getUser()) == null) {
            restaurante.setIdRestaurante(restauranteRepository.obtenerUltimoId().getIdRestaurante() + 1);
            restauranteRepository.save(restaurante);
            return "OK";
        }
        return "El usuario " + restaurante.getUser() + " ya existe. Verifique los datos.";
    }

    public String registrarIngrediente(Ingrediente ingrediente) {
        if (ingredienteRepository.verificarExistencia(ingrediente.getNombre()) == null) {
            ingrediente.setIdIngrediente(ingredienteRepository.obtenerUltimoId().getIdIngrediente() + 1);
            ingredienteRepository.save(ingrediente);
            return "OK";
        }
        return "El ingrediente " + ingrediente.getNombre() + " ya existe.";
    }

    public String registrarProducto(Producto producto) {
        if (productoRepository.verificarExistencia(producto.getRestaurante().getIdRestaurante(), producto.getNombre()) == null) {
            producto.setIdProducto(productoRepository.obtenerUltimoId().getIdProducto() + 1);
            productoRepository.save(producto);
            return "OK";
        }
        return "El Producto " + producto.getNombre() + " ya existe.";
    }

    public String registrarMenu(Menu menu) {
        if (menuRepository.verificarExistencia(menu.getRestaurante().getIdRestaurante(), menu.getNombre()) == null) {
            menu.setIdMenu(menuRepository.obtenerUltimoId().getIdMenu() + 1);
            menuRepository.save(menu);
            return "OK";
        }
        return "El Menu " + menu.getNombre() + " ya existe.";
    }

    public String registrarProductoIngrediente(ProductoIngrediente productoIngrediente) {
        productoIngrediente.setIdProductoIngrediente(productoIngredienteRepository.obtenerUltimoId().getIdProductoIngrediente() + 1);
        productoIngredienteRepository.save(productoIngrediente);
        return "OK";
    }

    public String registrarSeleccion(Seleccion seleccion) {
        seleccion.setIdSeleccion(seleccionRepository.obtenerUltimoId().getIdSeleccion() + 1);
        seleccionRepository.save(seleccion);
        return "OK";
    }
        
    public String registrarTarjeta(Cliente cliente, Tarjeta tarjeta) {

        // Revisar que haya un suario
        if (cliente == null)
            return "¡El usuario no puede ser nulo!";
        
        // Revisar que haya una tarjeta    
        if (tarjeta == null)
            return "¡La tarjeta no puede ser nula!";
        
        // Verificar que la tarjeta exista
        String numTarjeta = tarjeta.getNumTarjeta();

        Tarjeta tarjetaAux = tarjetaRepository.buscarPorNumTarjeta(numTarjeta);
        if (tarjetaAux != null) {
            // Verificar que tengan los mismos atributos
            if (!tarjeta.equals(tarjetaAux))
                return "Tarjeta rechazada, por favor verifique los datos.";

            // Revisar que la tarjeta de credito no pertenezca al usuario
            if (tarjetasClienteRepository.tarjetaAsignadaAlCliente(cliente.getIdCliente(),tarjeta.getNumTarjeta()) != null)
                return "Esta tarjeta ya está registrada para el usuario " + cliente.getCorreo() + ".";
            else {
                TarjetasCliente tarjetaCliente = new TarjetasCliente (
                    new TarjetasClienteId(cliente.getIdCliente(), numTarjeta));
                tarjetasClienteRepository.save(tarjetaCliente);
                return "OK";
            }
        }

        // Algoritmo de Luhn.
        int digitos_pares = 0;
        int digitos_impares = 0;
        for (int i = numTarjeta.length()-1; i >= 0; i--) {
            if (i % 2 == 0) {
                int digito = 2 * (int)(numTarjeta.charAt(i) - '0');
                if (digito > 9)
                    digito = 1 + digito % 10;

                digitos_pares += digito;
            }
            else
                digitos_impares += (int)(numTarjeta.charAt(i) - '0');
        }
        if ((digitos_pares + digitos_impares) % 10 != 0)
            return "El número '" + tarjeta.getNumTarjeta() + "' de tarjeta de crédito es inválido por el algoritmo de Luhn.";
        
        // Se valida el tipo de tarjeta que sea
        TipoTarjeta tipoTarjeta = tipoTarjetaRepository.tipoTarjeta(tarjeta.primerNumero());

        if (tipoTarjeta == null)
            return "El tipo de tarjeta que desea digitar no es aceptado.";

        // Salió bien
        tarjeta.setTipo(tipoTarjeta.getTipo());
        tarjetaRepository.save(tarjeta);

        TarjetasCliente tarjetaCliente = new TarjetasCliente (
            new TarjetasClienteId(cliente.getIdCliente(), numTarjeta));
        tarjetasClienteRepository.save(tarjetaCliente);
                    
        return "OK";
    }

    public void pruebas() {
        boolean confirmar;
        ArrayList<Producto> productosAEliminar = new ArrayList<>();
        ArrayList<Producto> opcionesProductosMenu = productoRepository.obtenerProductosPorMenu(1);
        ArrayList<Stock> stocks = stockRepository.obtenerStockPorMenu(1);
        ArrayList<Seleccion> seleccionesMenu = seleccionRepository.obtenerSeleccionPorMenu(1);
        for (Seleccion seleccion: seleccionesMenu) {
            System.out.println(seleccion.getIdSeleccion());
        }
        ArrayList<ProductoIngrediente> productosIngredientes = productoIngredienteRepository.obtenerProductoIngredientePorMenu(1);
        for (Producto producto : opcionesProductosMenu) {
            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                if (productoIngrediente.getProducto().getIdProducto() == producto.getIdProducto()) {
                    for (Stock stock : stocks) {
                        if (stock.getRestaurante().getIdRestaurante() == producto.getRestaurante().getIdRestaurante() && productoIngrediente.getIngrediente().getIdIngrediente() == stock.getIngrediente().getIdIngrediente()) {
                            System.out.println("Cantidad en stock: " + stock.getCantidadStock() + " - ingrediente: " + stock.getIngrediente().getIdIngrediente());
                            System.out.println("Cantidad de producto: " + productoIngrediente.getCantidad() + " - ingrediente: " + productoIngrediente.getIngrediente().getIdIngrediente());
                            if (stock.getCantidadStock() < productoIngrediente.getCantidad()) {
                                System.out.println("Eliminar----------------------------------------------------------------");
                                confirmar = true;
                                for (Producto productoAEliminar : productosAEliminar) {
                                    if (productoAEliminar.equals(producto)) {
                                        confirmar = false;
                                        break;
                                    }
                                }
                                if (confirmar) {
                                    productosAEliminar.add(producto);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Producto producto : productosAEliminar) {
            opcionesProductosMenu.remove(producto);
        }
        for (Producto producto : opcionesProductosMenu) {
            for (ProductoIngrediente productoIngrediente : productosIngredientes) {
                if (productoIngrediente.getProducto().getIdProducto() == producto.getIdProducto()) {
                    for (Stock stock : stocks) {
                        if (stock.getRestaurante().getIdRestaurante() == producto.getRestaurante().getIdRestaurante() && productoIngrediente.getIngrediente().getIdIngrediente() == stock.getIngrediente().getIdIngrediente()) {
                            stock.setCantidadStock(stock.getCantidadStock() - productoIngrediente.getCantidad());
                            stockRepository.save(stock);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void eliminarProducto(int id) {
        ArrayList<ProductoIngrediente> productoIngredientes = productoIngredienteRepository.obtenerProductoIngredietePorProducto(id);
        for (ProductoIngrediente pi : productoIngredientes) {
            productoIngredienteRepository.delete(pi);
        }
        productoRepository.deleteById(id);
    }

    public void eliminarMenu(int id) {
        ArrayList<Seleccion> selecciones = seleccionRepository.obtenerSeleccionPorMenu(id);
        for (Seleccion seleccion : selecciones) {
            seleccionRepository.delete(seleccion);
        }
        menuRepository.deleteById(id);
    }

    public String agregarStockEIngrediente(Stock stock) {
        stock.setIdStock(stockRepository.obtenerUltimoId().getIdStock() + 1);
        return modificarStockEIngrediente(stock);
    }

    public String modificarStockEIngrediente(Stock stock) {
        stockRepository.save(stock);
        return "OK";
    }
    
    public String eliminarstock(int id){
        Stock stock= stockRepository.findById(id).get();
        stockRepository.delete(stock);
        return "OK";
    }

    public String cambiarContrasenaCliente(Cliente cliente, String passwordViejo, String passwordNuevo) {
        if (!cliente.getPassword().equals(passwordViejo))
            return "¡La contraseña es incorrecta!";
        
        if (passwordViejo.equals(passwordNuevo))
            return "¡La nueva contraseña no puede ser la misma que la original!";
        
        // Validaciones de contraseña
        cliente.setPassword(passwordNuevo);
        clienteRepository.save(cliente);
        return "OK";
    }

}
