package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Modelo.Tarea;
import com.api.VigiControl.Repositorio.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private ITareaRepo tareaRepo;

    public List<Tarea> listarTareas(){
        return tareaRepo.findAll();
    }

    public Tarea buscarTarea(String id) {
        return tareaRepo.findById(id).get();
    }
    public Tarea ingresarTarea(Tarea tarea) {
        return tareaRepo.save(tarea);
    }

    public void eliminarTarea(String id) {
        tareaRepo.deleteById(id);
    }
}
