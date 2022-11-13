package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("menuSeleccionadoRepository")
public interface IMenuSeleccionadoRepository extends JpaRepository<MenuSeleccionado, Integer> {

    @Query(
            value = "SELECT * FROM Menu_Seleccionado ORDER BY idMenu_Seleccionado DESC LIMIT 1",
            nativeQuery = true
    )
    MenuSeleccionado obtenerUltimoId();

    @Query(
            value = "",
            nativeQuery = true
    )
    ArrayList<MenuSeleccionado> obtener(@Param("id") int id);

}
