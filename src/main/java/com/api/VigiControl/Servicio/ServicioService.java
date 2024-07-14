package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Modelo.Servicio;
import com.api.VigiControl.Repositorio.IServicioRepo;
import com.api.VigiControl.Request.RequestBusquedaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private IServicioRepo servicioRepo;

    public List<Servicio> listarServicios(){
        return servicioRepo.findAll();
    }

    public Servicio ingresarServicio(Servicio servicio) {
        return servicioRepo.save(servicio);
    }

    public Servicio buscarServicioByPersona(String personalID, LocalDate fecha) {
        return servicioRepo.buscarServicioByPersona(personalID, fecha);
    }
}
