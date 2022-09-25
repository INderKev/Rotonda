package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Orden;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("ordenRepository")
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {
}
