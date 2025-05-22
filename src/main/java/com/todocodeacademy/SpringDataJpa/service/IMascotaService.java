package com.todocodeacademy.SpringDataJpa.service;

import java.util.List;

import com.todocodeacademy.SpringDataJpa.model.Mascota;

public interface IMascotaService{

    //método para traer a todas las mascotas
    //lectura
    public List<Mascota> getMascotas();

    //alta
    public void saveMascota(Mascota mascota);

    //baja
    public void deleteMascota(Long id_mascota);

    //lectura de un solo objeto
    public Mascota findMascota(Long id_mascota);

    //edición/modificación
    public void editMascota(Long id_mascota, 
                            String nuevoNombre,
                            String nuevaEspecie, 
                            String nuevaRaza, 
                            String nuevoColor);

    public void editMascota(Mascota masco);

}
