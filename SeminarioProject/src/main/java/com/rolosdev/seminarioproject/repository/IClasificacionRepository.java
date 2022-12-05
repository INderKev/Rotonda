package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Clasificacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("clasificacionRepository")
public interface IClasificacionRepository extends JpaRepository<Clasificacion, Integer> {

    @Query(
            value = "SELECT * FROM Clasificacion ORDER BY idClasificacion DESC LIMIT 1",
            nativeQuery = true
    )
    Clasificacion obtenerUltimoId();

    @Query(
            value = "SELECT * FROM Clasificacion",
            nativeQuery = true
    )
    ArrayList<Clasificacion> obtenerTodasClasificaciones();

}
