package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("menuRepository")
public interface IMenuRepository extends JpaRepository<Menu, Integer> {
}
