package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Administrador;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("administradorRepository")
public interface IAdministradorRepository extends JpaRepository<Administrador, Integer> {
}
