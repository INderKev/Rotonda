package com.rolosdev.seminarioproject.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rolosdev.seminarioproject.entity.Tarjeta;



@Repository("tarjetaRepository")
public interface ITarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    @Query(
        value = "SELECT * FROM tarjeta WHERE numtarjeta = ?1 AND pin = ?2 AND tipo = ?3 AND fecha_caducidad = ?4",
        nativeQuery = true
    )
    Tarjeta verificarDatosTarjeta(@Param("numTarjeta") String numTarjeta, @Param("PIN") Integer pin, 
                            @Param("tipo") String tipo, @Param("fechaCaducidad") Date fechaCaducidad);

    @Query(
        value = "SELECT t.* FROM tarjeta t WHERE t.numtarjeta = ?1",
        nativeQuery = true
    )
    Tarjeta buscarPorNumTarjeta(@Param("numTarjeta") String numTarjeta);
}
