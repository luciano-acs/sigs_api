package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Grado;
import com.api.VigiControl.Modelo.Localidad;
import com.api.VigiControl.Repositorio.IGradoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradoService {

    @Autowired
    private IGradoRepo gradoRepo;

    public List<Grado> listarGrados(){return gradoRepo.findAll();}

    public Grado buscarGrado(Integer id) {
        return gradoRepo.findById(id).get();
    }

    public Grado ingresarGrado(Grado grado) {
        return gradoRepo.save(grado);
    }

    public void eliminarGrado(Integer id) {
        gradoRepo.deleteById(id);
    }
}
