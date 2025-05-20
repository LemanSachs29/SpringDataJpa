package com.todocodeacademy.SpringDataJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodeacademy.SpringDataJpa.model.Mascota;

@Repository
public interface IMascotaRepository extends JpaRepository <Mascota, Long>{

}
