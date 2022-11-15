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
            value = "SELECT * FROM producto_ingrediente WHERE idproducto = ?1",
            nativeQuery = true
    )
    ArrayList<ProductoIngrediente> obtenerProductoIngredietePorProducto(@Param("idProducto") int idProducto);


    @Query(
            value = "SELECT pi.* FROM producto_ingrediente pi, (SELECT idproducto AS pr FROM producto pr, (SELECT se.precio_bajo AS pb, se.precio_alto AS pa, se.idclasificacion AS ic, me.idrestaurante AS ir FROM menu me, seleccion se WHERE me.idmenu = se.idmenu AND me.idmenu = ?1) t1 WHERE pr.precio_producto >= t1.pb AND pr.precio_producto <= t1.pa AND pr.idclasificacion = t1.ic AND pr.idrestaurante = t1.ir) t1 WHERE t1.pr = pi.idproducto",
            nativeQuery = true
    )
    ArrayList<ProductoIngrediente> obtenerProductoIngredientePorMenu(@Param("idMenu") int idMenu);
}
