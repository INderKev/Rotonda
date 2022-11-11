package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(
            value = "SELECT * FROM Producto ORDER BY idProducto DESC LIMIT 1",
            nativeQuery = true
    )
    Producto obtenerUltimoId();
}
