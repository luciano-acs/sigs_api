package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServicioRepo extends JpaRepository<Servicio, Integer> {
}
