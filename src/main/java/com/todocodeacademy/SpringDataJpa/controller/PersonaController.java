 package com.todocodeacademy.SpringDataJpa.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.todocodeacademy.SpringDataJpa.model.Persona;
import com.todocodeacademy.SpringDataJpa.service.IPersonaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class PersonaController {


    @Autowired
    IPersonaService persoService;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas() {
        return persoService.getPersonas();
    }

    @GetMapping("/personas/traer/{id_perso}")
    public Persona buscarPorId(@PathVariable Long  id_perso) {
        return persoService.findPersona(id_perso);
    }
    
    @PostMapping("/personas/crear")
    public String savePersona (@RequestBody Persona perso){
        persoService.savePersona(perso);

        return "La persona fue creada correctamente";
    }


    @DeleteMapping("/personas/borrar/{id_perso}")
    public String deletePersona(@PathVariable Long id_perso){
        persoService.deletePersona(id_perso);

        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id_perso}")
    public Persona editPersona(@PathVariable Long id_perso, 
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellid_persoo") String nuevoApellid_persoo,
                               @RequestParam(required = false, name = "edad") Integer nuevaEdad){

                            
        //Llamar al service
        persoService.editPersona(id_perso, nuevoNombre, nuevoApellid_persoo, nuevaEdad);

        //Retornar la persona editada
        return persoService.findPersona(id_perso);
    }


    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona per){
        persoService.editPersona(per);

        return persoService.findPersona(per.getId());
    }
}
