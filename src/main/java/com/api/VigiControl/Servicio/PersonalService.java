package com.api.VigiControl.Servicio;

import com.api.VigiControl.DTO.DistritoPersonalDTO;
import com.api.VigiControl.DTO.EventosPersonalDTO;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Repositorio.IPersonalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

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

    public Personal buscarPorUsername(String username) {
        return personalRepo.buscarPorUsername(username);
    }

    public Integer personalbydistritos(Integer distrito) {
        return personalRepo.personalbydistritos(distrito);
    }

    public List<DistritoPersonalDTO> personalDistritos(List<String> nombreDistritos) {
        return personalRepo.personaldistritos(nombreDistritos);
    }

    public List<EventosPersonalDTO> eventos(){
        return personalRepo.eventos();
    }

    public List<EventosPersonalDTO> eventosPersonal(List<String> nombreEventos, List<String> nombreDistritos) {
        return personalRepo.eventosPersonal(nombreEventos, nombreDistritos);
    }

    public List<DistritoPersonalDTO> todosDistritos() {
        return personalRepo.todosdistritos();
    }

    public List<EventosPersonalDTO> eventosdistritos(List<String> nombreDistritos) {
        return personalRepo.eventosdistritos(nombreDistritos);
    }

    public List<EventosPersonalDTO> eventosSinDistritos(List<String> nombreEventos) {
        return personalRepo.eventosSinDistritos(nombreEventos);
    }
}
