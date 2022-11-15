package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(
            value = "SELECT * FROM Producto ORDER BY idProducto DESC LIMIT 1",
            nativeQuery = true
    )
    Producto obtenerUltimoId();

    @Query(
            value = "SELECT * FROM Producto WHERE idrestaurante = ?1 AND LOWER(nom_producto) = LOWER(?2)",
            nativeQuery = true
    )
    Producto verificarExistencia(@Param("id") int id, @Param("nombre") String nombre);

    @Query(
            value = "SELECT * FROM producto WHERE idrestaurante = ?1",
            nativeQuery = true
    )
    ArrayList<Producto> obtenerProductosPorRestaurante(@Param("idRestaurante") int idRestaurante);

    @Query(
            value = "SELECT pr.* FROM producto pr, (SELECT se.precio_bajo AS pb, se.precio_alto AS pa, se.idclasificacion AS ic, me.idrestaurante AS ir FROM menu me, seleccion se WHERE me.idmenu = se.idmenu AND me.idmenu = ?1) t1 WHERE pr.precio_producto >= t1.pb AND pr.precio_producto <= t1.pa AND pr.idclasificacion = t1.ic AND pr.idrestaurante = t1.ir",
            nativeQuery = true
    )
    ArrayList<Producto> obtenerProductosPorMenu(@Param("idMenu") int idMenu);
}
