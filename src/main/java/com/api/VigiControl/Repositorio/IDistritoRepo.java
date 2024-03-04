package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDistritoRepo extends JpaRepository<Distrito,Integer> {

//    @Query(value = "select d.idDistrito, c.nroComisaria from Distrito d inner join Comisaria c on c.distrito = d.idDistrito")
//    List<Object> listarPrueba();

//    @Query(value = "select d.idDistrito, c.nroComisaria from Distrito d inner join Comisaria c on c.distrito = d.idDistrito")
//    List<Distrito> listarPrueba();
}
