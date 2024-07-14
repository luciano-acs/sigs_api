package com.api.VigiControl.Repositorio;
import com.api.VigiControl.DTO.DistritoPersonalDTO;
import com.api.VigiControl.DTO.EventosPersonalDTO;
import com.api.VigiControl.Modelo.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPersonalRepo extends JpaRepository<Personal,String> {

    @Query(value = "SELECT p FROM Personal p where p.visible = 1")
    Page<Personal> listarPersonalLimiteOffset(Pageable pageable);

    @Query(value = "SELECT p FROM Personal p where p.personalID LIKE :id% AND p.visible = 1")
    Page<Personal> listarPersonalById(Pageable pageable, @Param("id") String id);

    Optional<Personal> findByUsername(String username);

    @Query(value = "Select p FROM Personal p where p.username = :username")
    Personal buscarPorUsername(@Param("username") String username);

    @Query(value = "select count (*) from Personal p inner join Distrito d on p.distritoID = d.distritoID where p.distritoID.distritoID = :distrito")
    Integer personalbydistritos(@Param("distrito") Integer distrito);

    @Query(value = "SELECT new com.api.VigiControl.DTO.DistritoPersonalDTO(d.nombre, count(*)) FROM Personal p INNER JOIN Distrito d ON p.distritoID = d.distritoID WHERE d.nombre IN :nombreDistritos GROUP BY d.nombre ORDER BY d.nombre")
    List<DistritoPersonalDTO> personaldistritos(@Param("nombreDistritos") List<String> nombreDistritos);

    @Query(value = "SELECT new com.api.VigiControl.DTO.DistritoPersonalDTO(d.nombre, count(*)) FROM Personal p INNER JOIN Distrito d ON p.distritoID = d.distritoID GROUP BY d.nombre ORDER BY d.nombre")
    List<DistritoPersonalDTO> todosdistritos();

    //TODOS LOS EVENTOS, TODOS LOS DISTRITOS
    @Query(value = "SELECT new com.api.VigiControl.DTO.EventosPersonalDTO(d.nombre, t.nombre,  count (*)) FROM Personal p INNER JOIN Distrito d ON d.distritoID = p.distritoID INNER JOIN Servicio s ON s.personalID = p.personalID INNER JOIN ServicioTarea st ON st.servicioID = s.servicioID INNER JOIN Tarea t ON t.tareaID = st.tareaID GROUP BY d.nombre, t.nombre")
    List<EventosPersonalDTO> eventos();

    //EVENTO/S PARA DETERMINADO DISTRITO/S
    @Query(value = "SELECT new com.api.VigiControl.DTO.EventosPersonalDTO(d.nombre, t.nombre,  count (*)) FROM Personal p INNER JOIN Distrito d ON d.distritoID = p.distritoID INNER JOIN Servicio s ON s.personalID = p.personalID INNER JOIN ServicioTarea st ON st.servicioID = s.servicioID INNER JOIN Tarea t ON t.tareaID = st.tareaID WHERE d.nombre IN (:nombreDistritos) AND t.tareaID IN (:nombreEventos) GROUP BY d.nombre, t.nombre")
    List<EventosPersonalDTO> eventosPersonal(@Param("nombreEventos") List<String> nombreEventos, @Param("nombreDistritos") List<String> nombreDistritos);

    //TODOS LOS DISTRITOS PARA DETERMINADO EVENTOS O EVENTO
    @Query(value = "SELECT new com.api.VigiControl.DTO.EventosPersonalDTO(d.nombre, t.nombre,  count (*)) FROM Personal p INNER JOIN Distrito d ON d.distritoID = p.distritoID INNER JOIN Servicio s ON s.personalID = p.personalID INNER JOIN ServicioTarea st ON st.servicioID = s.servicioID INNER JOIN Tarea t ON t.tareaID = st.tareaID WHERE t.tareaID IN (:nombreEventos) GROUP BY d.nombre, t.nombre")
    List<EventosPersonalDTO> eventosSinDistritos(@Param("nombreEventos") List<String> nombreEventos);

    //TODOS LOS EVENTOS PARA DETERMINADOS DISTRITOS O DISTRITO
    @Query(value = "SELECT new com.api.VigiControl.DTO.EventosPersonalDTO(d.nombre, t.nombre,  count (*)) FROM Personal p INNER JOIN Distrito d ON d.distritoID = p.distritoID INNER JOIN Servicio s ON s.personalID = p.personalID INNER JOIN ServicioTarea st ON st.servicioID = s.servicioID INNER JOIN Tarea t ON t.tareaID = st.tareaID WHERE d.nombre IN (:nombreDistritos) GROUP BY d.nombre, t.nombre")
    List<EventosPersonalDTO> eventosdistritos(@Param("nombreDistritos") List<String> nombreDistritos);
}
