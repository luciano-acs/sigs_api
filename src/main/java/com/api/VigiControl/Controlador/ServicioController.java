package com.api.VigiControl.Controlador;
import com.api.VigiControl.Modelo.Servicio;
import com.api.VigiControl.Request.RequestBusquedaServicio;
import com.api.VigiControl.Servicio.PersonalService;
import com.api.VigiControl.Servicio.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private PersonalService personalService;

    @GetMapping("/listar")
    public List<Servicio> listarServicios(){
        return servicioService.listarServicios();
    }

    @PostMapping("/serv")
    public Servicio ingresarServicio(@RequestBody Servicio servicio){
        System.out.println(servicio);
        return servicioService.ingresarServicio(servicio);
    }

    @PostMapping("/buscar")
    public Servicio buscarServicioByPersona(@RequestBody RequestBusquedaServicio requestBusquedaServicio){
        return servicioService.buscarServicioByPersona(requestBusquedaServicio.getNombre(), requestBusquedaServicio.getFecha());
    }
}
