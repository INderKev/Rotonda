package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Seleccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("seleccionRepository")
public interface ISeleccionRepository extends JpaRepository<Seleccion, Integer> {

    @Query(
            value = "SELECT * FROM Seleccion ORDER BY idseleccion DESC LIMIT 1",
            nativeQuery = true
    )
    Seleccion obtenerUltimoId();

}
