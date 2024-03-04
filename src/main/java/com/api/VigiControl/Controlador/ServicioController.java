package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Servicio;
import com.api.VigiControl.Servicio.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    public List<Servicio> listarServicios(){
        return servicioService.listarServicios();
    }
}
