package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

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
}
