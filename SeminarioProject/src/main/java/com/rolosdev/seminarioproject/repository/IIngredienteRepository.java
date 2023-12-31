package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Ingrediente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.ArrayList;
import java.util.List;


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

     @Query(
            value = "select I.idingrediente,I.nom_ingrediente,I.tipo_unidad,I.descripcion from ingrediente as I except (select  s.idingrediente,K.nom_ingrediente,k.tipo_unidad,k.descripcion from stock as s,ingrediente as k where s.idrestaurante=?1 and k.idingrediente=s.idingrediente)",
            nativeQuery = true
    )
    ArrayList<Ingrediente> obtenerIngredientesFaltantesderestaurante(@Param("idRestaurante") int idRestaurante);

    
    @Query(
        value = "SELECT i.nom_ingrediente, sum(s.cantidad_stock) FROM ingrediente i LEFT JOIN stock s ON s.idingrediente = i.idingrediente GROUP BY i.nom_ingrediente" ,
                nativeQuery = true
    )
    List<Object[]> listarIngredientes ();

    @Modifying
    @Query(
        value = "DELETE FROM ingrediente i WHERE i.nom_ingrediente = :nombre",
        nativeQuery = true
    )
    void borarIngrediente(@Param("nombre") String nomIngrediente);

    @Modifying
    @Query(
        value = "update ingrediente set descripcion = :nuevaDescripcion where lower(nom_ingrediente) = lower(:nombre)",
        nativeQuery = true
    )
    void modificarDescripcionIngrediente(@Param("nombre") String nomIngrediente, @Param("nuevaDescripcion") String desc);

    @Query(
        value = "SELECT * FROM ingrediente WHERE nom_ingrediente = :nombre",
        nativeQuery = true
    )
    Ingrediente getByNombre(String nombre);

    @Query(
        value = "SELECT * FROM ingrediente WHERE idingrediente = ?1",
        nativeQuery = true
    )
    Ingrediente buscaIngredientePorId(@Param("idIngrediente") int idIngrediente);
}
