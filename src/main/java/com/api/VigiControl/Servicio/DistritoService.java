package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Distrito;
import com.api.VigiControl.Repositorio.IDistritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {

    @Autowired
    private IDistritoRepo distritoRepo;

    public List<Distrito> listarDistritos() {
        return distritoRepo.findAll();
    }

    public Distrito buscarDistrito(Integer id) {
        return distritoRepo.findById(id).get();
    }

    public Distrito ingresarDistrito(Distrito distrito) {
        return distritoRepo.save(distrito);
    }

    public void eliminarDistrito(Integer id) {
        distritoRepo.deleteById(id);
    }
}
