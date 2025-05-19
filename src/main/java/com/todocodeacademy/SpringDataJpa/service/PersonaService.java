package com.todocodeacademy.SpringDataJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.SpringDataJpa.repository.IPersonaRepository;

@Service
public class PersonaService{

    @Autowired
    private IPersonaRepository persoRespRepo;
}
