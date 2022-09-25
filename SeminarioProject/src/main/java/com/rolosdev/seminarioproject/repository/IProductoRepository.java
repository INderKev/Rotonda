package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Producto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
