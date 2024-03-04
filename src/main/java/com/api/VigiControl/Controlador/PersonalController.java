package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Servicio.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/personal")
@CrossOrigin
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/listar/page")
    public Page<Personal> listarPersonal(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam(defaultValue = "id") String sortBy,
                                         @RequestParam(defaultValue = "ASC") String sortOrder,
                                         @RequestParam(required = false) String id){

        Pageable pageable = PageRequest.of(page-1, size, Sort.by(Sort.Direction.fromString(sortOrder),sortBy));

        if(id != null && !id.isEmpty()){
            return personalService.listarPersonalById(pageable, id);
        }else{
            return personalService.listarPersonal(pageable);
        }
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Personal> buscarPersonal(@PathVariable String id){
        try{
            Personal personalBusqueda = personalService.buscarPersonal(id);
            return new ResponseEntity<Personal>(personalBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persona")
    public Personal ingresarPersona(@RequestBody Personal personal){
        return personalService.ingresarPersona(personal);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPersonal(@PathVariable String id, @RequestBody Personal personal){
        try{
            Personal personalModificacion = personalService.buscarPersonal(id);
            personalModificacion.setApeYnom(personal.getApeYnom());
            personalModificacion.setCargo(personal.getCargo());

            personalService.ingresarPersona(personalModificacion);
            return new ResponseEntity<Personal>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPersonal(@PathVariable String id, @RequestBody Personal personal){
        try{
            Personal personalModificacion = personalService.buscarPersonal(id);
            personalModificacion.setVisible(personal.getVisible());

            personalService.ingresarPersona(personalModificacion);
            return new ResponseEntity<Personal>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
        }
    }
}
