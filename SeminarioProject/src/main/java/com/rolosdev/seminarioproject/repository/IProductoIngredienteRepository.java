package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.ProductoIngrediente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("productoIngredienteRepository")
public interface IProductoIngredienteRepository extends JpaRepository<ProductoIngrediente, Integer> {
}
