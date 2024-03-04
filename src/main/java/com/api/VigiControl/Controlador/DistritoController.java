package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Distrito;
import com.api.VigiControl.Servicio.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/listar")
    public List<Distrito> listarDistritos(){
        return distritoService.listarDistritos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Distrito> buscarDistrito(@PathVariable Integer id){
        try{
            Distrito distritoBusqueda = distritoService.buscarDistrito(id);
            return new ResponseEntity<Distrito>(distritoBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Distrito>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/distrito")
    public Distrito ingresarDistrito(@RequestBody Distrito distrito){
        return distritoService.ingresarDistrito(distrito);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Distrito distrito){
        try{
            Distrito distritoModificacion = distritoService.buscarDistrito(id);
            distritoModificacion.setComisarias(distrito.getComisarias());
            distritoModificacion.setNombre(distrito.getNombre());

            distritoService.ingresarDistrito(distritoModificacion);
            return new ResponseEntity<Distrito>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Distrito>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarDistrito(@PathVariable Integer id){
        distritoService.eliminarDistrito(id);
    }
}
