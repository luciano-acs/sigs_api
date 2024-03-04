package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Comisaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComisariaRepo extends JpaRepository<Comisaria, Integer> {
}
