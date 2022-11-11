package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("menuSeleccionadoRepository")
public interface IMenuSeleccionadoRepository extends JpaRepository<MenuSeleccionado, Integer> {

    @Query(
            value = "SELECT * FROM Menu_Seleccionado ORDER BY idMenu_Seleccionado DESC LIMIT 1",
            nativeQuery = true
    )
    MenuSeleccionado obtenerUltimoId();

}
