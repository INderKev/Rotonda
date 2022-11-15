package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock, Integer> {

    @Query(
            value = "SELECT * FROM stock ORDER BY idstock DESC LIMIT 1",
            nativeQuery = true
    )
    Stock obtenerUltimoId();

    @Query(
            value = "SELECT s.* FROM restaurante r, ingrediente i, stock s, producto_ingrediente pi, (SELECT idproducto AS pr, idrestaurante AS ir FROM producto pr, (SELECT se.precio_bajo AS pb, se.precio_alto AS pa, se.idclasificacion AS ic, me.idrestaurante AS ir FROM menu me, seleccion se WHERE me.idmenu = se.idmenu AND me.idmenu = ?1) t1 WHERE pr.precio_producto >= t1.pb AND pr.precio_producto <= t1.pa AND pr.idclasificacion = t1.ic AND pr.idrestaurante = t1.ir) t1 WHERE t1.ir = r.idrestaurante AND t1.pr = pi.idproducto AND s.idrestaurante = r.idrestaurante AND i.idingrediente = s.idingrediente AND pi.idingrediente = s.idingrediente",
            nativeQuery = true
    )
    ArrayList<Stock> obtenerStockPorMenu(@Param("idMenu") int idMenu);
}
