package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(
            value = "SELECT * FROM Cliente ORDER BY idcliente DESC LIMIT 1",
            nativeQuery = true
    )
    Cliente obtenerUltimoId();

    @Query(
            value = "SELECT * FROM cliente c WHERE c.correo = ?1 AND c.passwordcliente = ?2",
            nativeQuery = true
    )
    Cliente obtenerClienteLogin(@Param("correo") String correo, @Param("password") String password);

    @Query(
            value = "SELECT * FROM cliente c WHERE c.correo = ?1",
            nativeQuery = true
    )
    Cliente verificarExistencia(@Param("cuenta") String cuenta);

    @Query(
            value = "SELECT * FROM cliente WHERE idcliente = ?1",
            nativeQuery = true
    )
    Cliente verificarExistenciaIDcliente(@Param("id") int id);

}
