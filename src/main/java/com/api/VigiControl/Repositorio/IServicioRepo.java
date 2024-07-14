package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Modelo.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;

public interface IServicioRepo extends JpaRepository<Servicio, Integer> {

    @Query(value = "Select s FROM Servicio s where s.personalID.personalID = :personalID AND s.fecha = :fecha")
    Servicio buscarServicioByPersona(@Param("personalID") String personalID, @Param("fecha") LocalDate fecha);
}
