package com.api.VigiControl.Controlador;

import com.api.VigiControl.DTO.DistritoPersonalDTO;
import com.api.VigiControl.DTO.EventosPersonalDTO;
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

import java.util.List;

@RestController
@RequestMapping("/personal")
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

    @GetMapping("/user/{username}")
    public ResponseEntity<Personal> buscarPorUsername(@PathVariable String username){
        try{
            Personal personal = personalService.buscarPorUsername(username);
            return new ResponseEntity<Personal>(personal,HttpStatus.OK);
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
            personalModificacion.setGradoID(personal.getGradoID());
            personalModificacion.setDistritoID(personal.getDistritoID());

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

    @GetMapping("/distrito/{distrito}")
    public Integer personalbydistritos(@PathVariable Integer distrito){
        return personalService.personalbydistritos(distrito);
    }

    @GetMapping("/distritos")
    public List<DistritoPersonalDTO> personalDistritos(@RequestParam(required = false) List<String> nombreDistritos){
        if (nombreDistritos == null || nombreDistritos.isEmpty()) {
            return personalService.todosDistritos();
        } else {
            return personalService.personalDistritos(nombreDistritos);
        }
    }

    @GetMapping("/eventos")
    public List<EventosPersonalDTO> eventosPersonal(@RequestParam(required = false) List<String> nombreDistritos, @RequestParam(required = false) List<String> nombreEventos){
        if (nombreDistritos != null && !nombreDistritos.isEmpty() && (nombreEventos == null || nombreEventos.isEmpty())) {
            return personalService.eventosdistritos(nombreDistritos);
        } else if (nombreEventos != null && !nombreEventos.isEmpty() && (nombreDistritos == null || nombreDistritos.isEmpty())) {
            return personalService.eventosSinDistritos(nombreEventos);
        } else if (nombreEventos == null || nombreEventos.isEmpty() && nombreDistritos == null || nombreDistritos.isEmpty()) {
            return personalService.eventos();
        } else {
            return personalService.eventosPersonal(nombreEventos, nombreDistritos);
        }
    }
}
