package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Servicio;
import com.api.VigiControl.Repositorio.IServicioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private IServicioRepo servicioRepo;

    public List<Servicio> listarServicios(){
        return servicioRepo.findAll();
    }
}
