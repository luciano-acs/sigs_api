package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Horario;
import com.api.VigiControl.Servicio.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    public List<Horario> listarHorarios(){
        return horarioService.listarHorarios();
    }
}
