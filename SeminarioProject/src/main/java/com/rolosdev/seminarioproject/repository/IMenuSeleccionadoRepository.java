package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.MenuSeleccionado;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("menuSeleccionadoRepository")
public interface IMenuSeleccionadoRepository extends JpaRepository<MenuSeleccionado, Integer> {
}
