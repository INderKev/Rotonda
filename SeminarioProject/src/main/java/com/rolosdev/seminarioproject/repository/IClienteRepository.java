package com.rolosdev.seminarioproject.repository;

import com.rolosdev.seminarioproject.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
}
