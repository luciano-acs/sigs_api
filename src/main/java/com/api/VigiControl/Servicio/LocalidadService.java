package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Domicilio;
import com.api.VigiControl.Modelo.Localidad;
import com.api.VigiControl.Repositorio.ILocalidadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadService {

    @Autowired
    private ILocalidadRepo localidadRepo;

    public List<Localidad> listarLocalidades() {
        return localidadRepo.findAll();
    }

    public Localidad buscarLocalidad(Integer id) {
        return localidadRepo.findById(id).get();
    }

    public Localidad ingresarLocalidad(Localidad localidad) {
        return localidadRepo.save(localidad);
    }

    public void eliminarLocalidad(Integer id) {
        localidadRepo.deleteById(id);
    }
}
