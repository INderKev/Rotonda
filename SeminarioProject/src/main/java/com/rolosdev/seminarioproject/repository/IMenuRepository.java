package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("menuRepository")
public interface IMenuRepository extends JpaRepository<Menu, Integer> {

    @Query(
            value = "SELECT * FROM Menu ORDER BY idMenu DESC LIMIT 1",
            nativeQuery = true
    )
    Menu obtenerUltimoId();

}
