package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Comisaria;
import com.api.VigiControl.Servicio.ComisariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comisarias")
public class ComisariaController {

    @Autowired
    private ComisariaService comisariaService;

    @GetMapping("/listar")
    public List<Comisaria> listarComisarias(){
        return comisariaService.listarComisarias();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Comisaria> buscarComisaria(@PathVariable Integer id){
        try{
            Comisaria comisariaBusqueda = comisariaService.buscarComisaria(id);
            return new ResponseEntity<Comisaria>(comisariaBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Comisaria>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/comisaria")
    public Comisaria ingresarComisaria(@RequestBody Comisaria comisaria){
        return comisariaService.ingresarComisaria(comisaria);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarComisaria(@PathVariable Integer id, @RequestBody Comisaria comisaria){
        try{
            Comisaria comisariaModificacion = comisariaService.buscarComisaria(id);
            comisariaModificacion.setNombre(comisaria.getNombre());

            comisariaService.ingresarComisaria(comisariaModificacion);
            return new ResponseEntity<Comisaria>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Comisaria>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarComisaria(@PathVariable Integer id){
        comisariaService.eliminarComisaria(id);
    }
}
