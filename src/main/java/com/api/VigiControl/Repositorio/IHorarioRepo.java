package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Horario;
import com.api.VigiControl.Modelo.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IHorarioRepo extends JpaRepository<Horario, Integer> {
    @Query(value = "Select h FROM Horario h where h.nombre = :nombre")
    Horario findByNombre(@Param("nombre") String nombre);
}
