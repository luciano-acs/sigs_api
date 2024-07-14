package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tarea {

    @Id
    @Column(length = 3)
    private String tareaID;
    private String nombre;
    @OneToMany(mappedBy = "servicioTareaID")
    @JsonIgnore
    private List<ServicioTarea> servicioTareasList;
}
