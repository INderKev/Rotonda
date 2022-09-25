package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Seleccion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("seleccionRepository")
public interface ISeleccionRepository extends JpaRepository<Seleccion, Integer> {
}
