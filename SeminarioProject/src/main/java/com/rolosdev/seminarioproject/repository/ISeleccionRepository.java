package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Seleccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("seleccionRepository")
public interface ISeleccionRepository extends JpaRepository<Seleccion, Integer> {

    @Query(
            value = "SELECT * FROM Seleccion ORDER BY idseleccion DESC LIMIT 1",
            nativeQuery = true
    )
    public Seleccion obtenerUltimoId();

    @Query(
            value = "SELECT s.* FROM menu_seleccionado ms, seleccion s, orden o WHERE s.idmenu_seleccionado = ms.idmenu_seleccionado AND ms.idmenu_seleccionado = o.idmenu_seleccionado AND o.idcompra = ?1",
            nativeQuery = true
    )
    public ArrayList<Seleccion> obtenerSeleccionesPorCompra(@Param("idCompra") int idCompra);

    @Query(
            value = "SELECT s.* FROM seleccion s WHERE s.idmenu = ?1",
            nativeQuery = true
    )
    public ArrayList<Seleccion> obtenerSeleccionPorMenu(@Param("idMenu") int idMenu);

}
