package com.todocodeacademy.SpringDataJpa.service;

import java.util.List;

import com.todocodeacademy.SpringDataJpa.model.Persona;

public interface IPersonaService {


    //método para traer a todas las personas
    //lectura
    public List<Persona> getPersonas();

    //alta
    public void savePersona(Persona persona);

    //baja
    public void deletePersona(Long id_perso);

    //lectura de un solo objeto
    public Persona findPersona(Long id_perso);

    //edición/modificación
    public void editPersona(Long id_perso, 
                            String nuevoNombre, 
                            String nuevoApellido, 
                            Integer nuevaEdad);

    public Persona editPersona(Persona per);

}
