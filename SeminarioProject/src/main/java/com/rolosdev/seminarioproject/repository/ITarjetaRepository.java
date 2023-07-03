package com.rolosdev.seminarioproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rolosdev.seminarioproject.entity.Tarjeta;



@Repository("tarjetaRepository")
public interface ITarjetaRepository extends JpaRepository<Tarjeta, Integer> {

    @Query(
        value = "SELECT identificador FROM tipo_tarjeta",
        nativeQuery = true
    )
    int[] tiposTarjetas();
}
