package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.ServicioTarea;
import com.api.VigiControl.Servicio.ServicioTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ata")
public class ServicioTareaController {

    @Autowired
    private ServicioTareaService servicioTareaService;

    @GetMapping("/listar")
    public List<ServicioTarea> listarServicioTareas(){return servicioTareaService.listarServicioTareas();}

}
