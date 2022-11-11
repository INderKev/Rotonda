package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock, Integer> {

    @Query(
            value = "SELECT * FROM stock ORDER BY idstock DESC LIMIT 1",
            nativeQuery = true
    )
    Stock obtenerUltimoId();
}
