package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Domicilio;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Repositorio.IPersonalRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
public class PersonalService {

    @Autowired
    private IPersonalRepo personalRepo;

    public Page<Personal> listarPersonal(Pageable pageable){
        return personalRepo.listarPersonalLimiteOffset(pageable);
    }
    public Page<Personal> listarPersonalById(Pageable pageable, String id){
        return personalRepo.listarPersonalById(pageable,id);
    }
    public Personal buscarPersonal(String id) {
        return personalRepo.findById(id).get();
    }
    public Personal ingresarPersona(Personal personal) {
        return personalRepo.save(personal);
    }

}
