package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
