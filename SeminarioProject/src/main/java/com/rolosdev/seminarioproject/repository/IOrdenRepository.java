package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("ordenRepository")
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {

    @Query(
            value = "SELECT * FROM Orden ORDER BY idOrden DESC LIMIT 1",
            nativeQuery = true
    )
    Orden obtenerUltimoId();

}
