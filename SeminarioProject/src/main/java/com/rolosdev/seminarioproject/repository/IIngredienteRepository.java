package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("ingredienteRepository")
public interface IIngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    @Query(
            value = "SELECT * FROM Ingrediente ORDER BY idIngrediente DESC LIMIT 1",
            nativeQuery = true
    )
    Ingrediente obtenerUltimoId();

    @Query(
            value = "SELECT * FROM Ingrediente WHERE LOWER(nom_ingrediente) = LOWER(?1)",
            nativeQuery = true
    )
    Ingrediente verificarExistencia(@Param("ingrediente") String ingrediente);

    @Query(
            value = "SELECT i.* FROM producto_ingrediente pi, ingrediente i WHERE pi.idingrediente = i.idingrediente AND pi.idproducto = ?1",
            nativeQuery = true
    )
    ArrayList<Ingrediente> obtenerIngredientesPorProducto(@Param("idProducto") int idProducto);

    @Query(
            value = "SELECT i.* FROM ingrediente i, producto_ingrediente pi, (SELECT pr.idproducto AS ip FROM producto pr, (SELECT se.precio_bajo AS pb, se.precio_alto AS pa, se.idclasificacion AS ic, me.idrestaurante AS ir FROM menu me, seleccion se WHERE me.idmenu = se.idmenu AND me.idmenu = ?1) t1 WHERE pr.precio_producto >= t1.pb AND pr.precio_producto <= t1.pa AND pr.idclasificacion = t1.ic AND pr.idrestaurante = t1.ir) t1 WHERE i.idingrediente = pi.idingrediente AND pi.idproducto = t1.ip",
            nativeQuery = true
    )
    ArrayList<Ingrediente> obtenerIngredientesPorMenu(@Param("idMenu") int idMenu);

}
