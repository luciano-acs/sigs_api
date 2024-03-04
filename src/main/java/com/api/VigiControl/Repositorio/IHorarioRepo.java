package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHorarioRepo extends JpaRepository<Horario, Integer> {
}
