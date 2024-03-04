package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Distrito;
import com.api.VigiControl.Modelo.Domicilio;
import com.api.VigiControl.Repositorio.IDomicilioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {

    @Autowired
    private IDomicilioRepo domicilioRepo;

    public List<Domicilio> listarDomicilios() {
        return domicilioRepo.findAll();
    }

    public Domicilio buscarDomicilio(Integer id) {
        return domicilioRepo.findById(id).get();
    }

    public Domicilio ingresarDomicilio(Domicilio domicilio) {
        return domicilioRepo.save(domicilio);
    }

    public void eliminarDomicilio(Integer id) {
        domicilioRepo.deleteById(id);
    }
}
