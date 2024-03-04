package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Comisaria;
import com.api.VigiControl.Repositorio.IComisariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisariaService {

    @Autowired
    private IComisariaRepo comisariaRepo;

    public List<Comisaria> listarComisarias() {
        return comisariaRepo.findAll();
    }

    public Comisaria buscarComisaria(Integer id) {
        return comisariaRepo.findById(id).get();
    }

    public Comisaria ingresarComisaria(Comisaria comisaria) {
        return comisariaRepo.save(comisaria);
    }

    public void eliminarComisaria(Integer id) {
        comisariaRepo.deleteById(id);
    }
}
