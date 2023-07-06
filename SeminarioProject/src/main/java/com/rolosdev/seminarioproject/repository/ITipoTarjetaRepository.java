package com.rolosdev.seminarioproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rolosdev.seminarioproject.entity.TipoTarjeta;

@Repository("tipoTarjetaRepository")
public interface ITipoTarjetaRepository extends JpaRepository<TipoTarjeta, Integer>{
    
    @Query(
        value = "SELECT * FROM tipo_tarjeta where identificador = ?1",
        nativeQuery = true
    )
    TipoTarjeta tipoTarjeta(@Param("identificador") int identificador);

    @Query(
        value = "SELECT identificador FROM tipo_tarjeta",
        nativeQuery = true
    )
    int[] tiposTarjetas();

}
