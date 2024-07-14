package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Horario;
import com.api.VigiControl.Repositorio.IHorarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private IHorarioRepo horarioRepo;

    public List<Horario> listarHorarios(){
        return horarioRepo.findAll();
    }

    public Horario listarHorarioByID(int id) {
        return horarioRepo.findById(id).get();
    }

    public Horario listarHorarioByNombre(String nombre) {
        return horarioRepo.findByNombre(nombre);
    }
}
