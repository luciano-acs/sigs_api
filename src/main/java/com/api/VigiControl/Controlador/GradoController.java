package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Grado;
import com.api.VigiControl.Servicio.GradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grados")

public class GradoController {

    @Autowired
    private GradoService gradoService;

    @GetMapping("/listar")
    public List<Grado> listarGrados(){return gradoService.listarGrados();}

    @GetMapping("/listar/{id}")
    public ResponseEntity<Grado> buscarGrado(@PathVariable Integer id){
        try{
            Grado gradoBusqueda = gradoService.buscarGrado(id);
            return new ResponseEntity<Grado>(gradoBusqueda, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Grado>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/grado")
    public Grado ingresarGrado(@RequestBody Grado grado){
        return gradoService.ingresarGrado(grado);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> modificarGrado(@RequestBody Grado grado, @PathVariable Integer id){
        try{
            Grado gradoModificacion = gradoService.buscarGrado(id);
            gradoModificacion.setGrado(grado.getGrado());
            gradoModificacion.setPersonal(grado.getPersonal());
            return new ResponseEntity<Grado>(gradoModificacion,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Grado>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarGrado(@PathVariable Integer id){gradoService.eliminarGrado(id);}
}
