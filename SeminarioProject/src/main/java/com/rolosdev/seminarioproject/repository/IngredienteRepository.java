package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("ingredienteRepository")
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    @Query(
            value = "SELECT * FROM Ingrediente ORDER BY idIngrediente DESC LIMIT 1",
            nativeQuery = true
    )
    Ingrediente obtenerUltimoId();

}
