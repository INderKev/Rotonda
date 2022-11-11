package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Administrador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("administradorRepository")
public interface IAdministradorRepository extends JpaRepository<Administrador, Integer> {
    @Query(
            value = "SELECT * FROM administrador c WHERE c.user_administrador = ?1 AND c.password_administrador = ?2",
            nativeQuery = true
    )
    Administrador obtenerAdministradorLogin(@Param("correo") String correo, @Param("password") String password);

    @Query(
            value = "SELECT * FROM administrador c WHERE c.user_administrador = ?1",
            nativeQuery = true
    )
    Administrador verificarExistencia(@Param("cuenta") String cuenta);

    @Query(
            value = "SELECT * FROM administrador ORDER BY administradorid DESC LIMIT 1",
            nativeQuery = true
    )
    Administrador obtenerUltimoId();

}
