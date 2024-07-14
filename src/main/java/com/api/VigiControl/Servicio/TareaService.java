package com.api.VigiControl.Servicio;

import com.api.VigiControl.DTO.TareaDTO;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Modelo.Tarea;
import com.api.VigiControl.Repositorio.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TareaService {

    @Autowired
    private ITareaRepo tareaRepo;

    public List<TareaDTO> listarTareas(){
        List<Tarea> tareas = tareaRepo.findAll();
        return tareas.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TareaDTO convertToDto(Tarea tarea) {
        TareaDTO tareaDTO = new TareaDTO();
        tareaDTO.setTareaID(tarea.getTareaID());
        tareaDTO.setNombre(tarea.getNombre());
        return tareaDTO;
    }

    public Tarea buscarTarea(String id) {
        return tareaRepo.findById(id).get();
    }
//    public Tarea ingresarTarea(Tarea tarea) {
//        return tareaRepo.save(tarea);
//    }
//
//    public void eliminarTarea(String id) {
//        tareaRepo.deleteById(id);
//    }
}
