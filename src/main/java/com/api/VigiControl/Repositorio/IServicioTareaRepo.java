package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.ServicioTarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioTareaRepo extends JpaRepository<ServicioTarea, Integer> {
}
