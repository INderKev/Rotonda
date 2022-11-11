package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Restaurante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("restauranteRepository")
public interface IRestauranteRepository extends JpaRepository<Restaurante, Integer> {
    @Query(
            value = "SELECT * FROM Restaurante ORDER BY idrestaurante DESC LIMIT 1",
            nativeQuery = true
    )
    Restaurante obtenerUltimoId();

    @Query(
            value = "SELECT * FROM restaurante c WHERE c.usuario_restaurante = ?1 AND c.password = ?2",
            nativeQuery = true
    )
    Restaurante obtenerRestauranteLogin(@Param("correo") String correo, @Param("password") String password);

    @Query(
            value = "SELECT * FROM restaurante c WHERE c.usuario_restaurante = ?1",
            nativeQuery = true
    )
    Restaurante verificarExistencia(@Param("cuenta") String cuenta);

}
