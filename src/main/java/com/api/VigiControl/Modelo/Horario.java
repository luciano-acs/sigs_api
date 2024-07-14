package com.api.VigiControl.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Horario {

    @Id
    private int horarioID;
    private String nombre;
    private Time horarioInicio;
    private Time horarioFin;
    @OneToMany(mappedBy = "servicioID", fetch = FetchType.EAGER)
    private List<Servicio> servicioList;

}
