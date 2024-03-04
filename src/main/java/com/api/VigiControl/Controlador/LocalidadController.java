package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Localidad;
import com.api.VigiControl.Servicio.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {

    @Autowired
    private LocalidadService localidadService;

    @GetMapping("/listar")
    public List<Localidad> listarLocalidades(){
        return localidadService.listarLocalidades();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Localidad> buscarLocalidad(@PathVariable Integer id){
        try{
            Localidad localidadBusqueda = localidadService.buscarLocalidad(id);
            return new ResponseEntity<Localidad>(localidadBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Localidad>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/localidad")
    public Localidad ingresarLocalidad(@RequestBody Localidad localidad){
        return localidadService.ingresarLocalidad(localidad);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarLocalidad(@PathVariable Integer id, @RequestBody Localidad localidad){
        try{
            Localidad localidadModificacion = localidadService.buscarLocalidad(id);
            localidadModificacion.setDomicilios(localidad.getDomicilios());
            localidadModificacion.setNombre(localidad.getNombre());

            localidadService.ingresarLocalidad(localidadModificacion);
            return new ResponseEntity<Localidad>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Localidad>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarLocalidad(@PathVariable Integer id){
        localidadService.eliminarLocalidad(id);
    }
}
