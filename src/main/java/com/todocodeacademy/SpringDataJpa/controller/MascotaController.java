package com.todocodeacademy.SpringDataJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.todocodeacademy.SpringDataJpa.model.Mascota;
import com.todocodeacademy.SpringDataJpa.service.IMascotaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MascotaController {


    @Autowired
    IMascotaService iMascotaService;

     @GetMapping("/mascotas/traer")
    public List<Mascota> getMascota() {
        return iMascotaService.getMascotas();
    }

    @GetMapping("/mascotas/traer/{id}")
    public Mascota buscarPorId(@PathVariable Long  id_mascota) {
        return iMascotaService.findMascota(id_mascota);
    }
    
    @PostMapping("/mascotas/crear")
    public String saveMascota (@RequestBody Mascota mascota){
        iMascotaService.saveMascota(mascota);

        return "La mascota fue creada correctamente";
    }


    @DeleteMapping("/mascotas/borrar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota){
        iMascotaService.deleteMascota(id_mascota);

        return "La mascota fue eliminada correctamente";
    }

    @PutMapping("/mascotas/editar/{id_mascota}")
    public Mascota editMascota(@PathVariable Long id_mascota, 
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "especie") String nuevaEspecie,
                               @RequestParam(required = false, name = "raza") String nuevaRaza,
                               @RequestParam(required = false, name = "color") String nuevoColor){

                            
        //Llamar al service
        iMascotaService.editMascota(id_mascota, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);

        //Retornar la persona editada
        return iMascotaService.findMascota(id_mascota);
    }

    
}
