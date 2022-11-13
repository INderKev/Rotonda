package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("menuRepository")
public interface IMenuRepository extends JpaRepository<Menu, Integer> {

    @Query(
            value = "SELECT * FROM Menu ORDER BY idMenu DESC LIMIT 1",
            nativeQuery = true
    )
    Menu obtenerUltimoId();

    @Query(
            value = "SELECT * FROM Menu WHERE idrestaurante = ?1 AND LOWER(nom_menu) = LOWER(?2)",
            nativeQuery = true
    )
    Menu verificarExistencia(@Param("id") int id, @Param("nombre") String nombre);

    @Query(
            value = "SELECT * FROM menu WHERE idrestaurante = ?1",
            nativeQuery = true
    )
    ArrayList<Menu> obtenerMenusPorRestaurante(@Param("idRestaurante") int idRestaurante);

}
