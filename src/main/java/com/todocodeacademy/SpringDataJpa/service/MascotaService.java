package com.todocodeacademy.SpringDataJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.SpringDataJpa.model.Mascota;
import com.todocodeacademy.SpringDataJpa.repository.IMascotaRepository;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascoRepo;


    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascoRepo.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascoRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        Mascota mascota = mascoRepo.findById(id_mascota).orElse(null);
        return mascota;
    }

    @Override
    public void editMascota(Long id_mascota, 
                            String nuevoNombre, 
                            String nuevaEspecie, 
                            String nuevaRaza,
                            String nuevoColor) {
        
                                
        //Busco el objeto
        Mascota mascota = this.findMascota(id_mascota);

        //Edición del objeto
        if (nuevoNombre != null) {
            mascota.setNombre(nuevoNombre);
        }

        if (nuevaEspecie != null) {
            mascota.setEspecie(nuevaEspecie);
        }

        if (nuevaRaza != null) {
            mascota.setRaza(nuevaRaza);
        }

        if (nuevoColor != null) {
            mascota.setColor(nuevoColor);
        }

        //Salvar los cambios
        this.saveMascota(mascota);
    }

}
