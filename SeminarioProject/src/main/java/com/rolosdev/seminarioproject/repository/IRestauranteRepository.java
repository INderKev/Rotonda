package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("restauranteRepository")
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
