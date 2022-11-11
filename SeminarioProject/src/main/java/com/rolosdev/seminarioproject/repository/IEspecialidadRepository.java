package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Especialidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("especialidadRepository")
public interface IEspecialidadRepository extends JpaRepository<Especialidad, Integer> {

    @Query(
            value = "SELECT * FROM Especialidad ORDER BY idEspecialidad DESC LIMIT 1",
            nativeQuery = true
    )
    Especialidad obtenerUltimoId();

}
