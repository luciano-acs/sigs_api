package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Horario;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Servicio.HorarioService;
import org.apache.tomcat.websocket.PojoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/listar")
    public List<Horario> listarHorarios(){
        return horarioService.listarHorarios();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Horario> listarHorarioByID(@PathVariable int id){
        try{
            Horario horarioBusqueda = horarioService.listarHorarioByID(id);
            return new ResponseEntity<Horario>(horarioBusqueda, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Horario>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/horario/{nombre}")
    public ResponseEntity<Horario> listarHorarioByNombre(@PathVariable String nombre){
        try{
            Horario horarioNombreBusqueda = horarioService.listarHorarioByNombre(nombre);
            return new ResponseEntity<Horario>(horarioNombreBusqueda, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Horario>(HttpStatus.NOT_FOUND);
        }
    }
}
