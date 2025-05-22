package com.todocodeacademy.SpringDataJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.SpringDataJpa.model.Persona;
import com.todocodeacademy.SpringDataJpa.repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        persoRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id_perso) {
        persoRepo.deleteById(id_perso);
    }

    @Override
    public Persona findPersona(Long id_perso) {
        return persoRepo.findById(id_perso).orElse(null);
    }

    @Override
    public void editPersona(Long id_perso, 
                            String nuevoNombre, 
                            String nuevoApellido, 
                            Integer nuevaEdad) {
        //busco el objeto
        Persona perso = this.findPersona(id_perso);

        //Edición del objeto
        if (nuevoNombre != null){
            perso.setNombre(nuevoNombre);
        }
        if (nuevoApellido != null){
            perso.setApellido(nuevoApellido);
        }
        if (nuevaEdad != null){
            perso.setEdad(nuevaEdad);
        }

        //Salvar los cambios
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona per) {
        persoRepo.save(per);
    }
}
