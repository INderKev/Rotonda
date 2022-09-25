package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock, Integer> {

}
