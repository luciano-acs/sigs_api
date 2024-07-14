package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.ServicioTarea;
import com.api.VigiControl.Repositorio.IServicioTareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTareaService {

    @Autowired
    private IServicioTareaRepo servicioTareaRepo;

    public List<ServicioTarea> listarServicioTareas(){
        return servicioTareaRepo.findAll();
    }

    public ServicioTarea ingresarST(ServicioTarea st) {
        return servicioTareaRepo.save(st);
    }
}
