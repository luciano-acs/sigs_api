package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITareaRepo extends JpaRepository<Tarea,String> {
}
