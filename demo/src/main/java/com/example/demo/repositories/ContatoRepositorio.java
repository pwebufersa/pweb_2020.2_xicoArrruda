package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.models.Contato;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long> {

}
