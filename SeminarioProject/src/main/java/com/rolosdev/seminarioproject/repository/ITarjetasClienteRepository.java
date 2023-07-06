package com.rolosdev.seminarioproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rolosdev.seminarioproject.entity.TarjetasCliente;

@Repository("tarjetasClienteRepository")
public interface ITarjetasClienteRepository extends JpaRepository<TarjetasCliente, Integer>{
    @Query(
        value = "SELECT * FROM tarjetas_cliente tc WHERE tc.idcliente = ?1 AND tc.numtarjeta = ?2",
        nativeQuery = true
    )
    TarjetasCliente tarjetaAsignadaAlCliente(@Param("idCliente") int idCliente, @Param("numTarjeta") String numTarjeta);
}
