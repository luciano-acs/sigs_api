package com.api.VigiControl.Repositorio;
import com.api.VigiControl.Modelo.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface IPersonalRepo extends JpaRepository<Personal,String> {

    @Query(value = "SELECT p FROM Personal p where p.visible = 1")
    Page<Personal> listarPersonalLimiteOffset(Pageable pageable);

    @Query(value = "SELECT p FROM Personal p where p.id = :id AND p.visible = 1")
    Page<Personal> listarPersonalById(Pageable pageable, @Param("id") String id);

    Optional<Personal> findByUsername(String username);
}
