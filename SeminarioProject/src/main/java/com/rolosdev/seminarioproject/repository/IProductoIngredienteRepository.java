package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.ProductoIngrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("productoIngredienteRepository")
public interface IProductoIngredienteRepository extends JpaRepository<ProductoIngrediente, Integer> {
    @Query(
            value = "SELECT * FROM Producto_Ingrediente ORDER BY idProductoIngrediente DESC LIMIT 1",
            nativeQuery = true
    )
    ProductoIngrediente obtenerUltimoId();

    @Query(
            value = "",
            nativeQuery = true
    )
    ArrayList<ProductoIngrediente> obtener(@Param("id") int id);
}
