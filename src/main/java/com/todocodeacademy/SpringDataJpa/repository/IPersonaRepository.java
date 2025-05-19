package com.todocodeacademy.SpringDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.SpringDataJpa.model.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Long>{

}
