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

    @GetMapping("/personas/traer/{id}")
    public Persona buscarPorId(@PathVariable Long  id) {
        return persoService.findPersona(id);
    }
    
    @PostMapping("/personas/crear")
    public String savePersona (@RequestBody Persona perso){
        persoService.savePersona(perso);

        return "La persona fue creada correctamente";
    }


    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoService.deletePersona(id);

        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, 
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") Integer nuevaEdad){

                            
        //Llamar al service
        persoService.editPersona(id, nuevoNombre, nuevoApellido, nuevaEdad);

        //Retornar la persona editada
        return persoService.findPersona(id);
    }


    @PutMapping("/personas/editar")
    public Persona editMascota(@RequestBody Persona per){
        persoService.editPersona(per);

        return persoService.findPersona(per.getId());
    }
}
