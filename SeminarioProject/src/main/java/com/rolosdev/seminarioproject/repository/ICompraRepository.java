package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Compra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("compraRepository")
public interface ICompraRepository extends JpaRepository<Compra, Integer> {

    @Query(
            value = "SELECT * FROM Compra ORDER BY idCompra DESC LIMIT 1",
            nativeQuery = true
    )
    Compra obtenerUltimoId();

}
