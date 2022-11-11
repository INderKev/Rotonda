package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Clasificacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("clasificacionRepository")
public interface IClasificacionRepository extends JpaRepository<Clasificacion, Integer> {

    @Query(
            value = "SELECT * FROM Clasificacion ORDER BY idClasificacion DESC LIMIT 1",
            nativeQuery = true
    )
    Clasificacion obtenerUltimoId();

}
