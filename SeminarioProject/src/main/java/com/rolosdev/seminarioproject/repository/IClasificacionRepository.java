package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Clasificacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("clasificacionRepository")
public interface IClasificacionRepository extends JpaRepository<Clasificacion, Integer> {
}
