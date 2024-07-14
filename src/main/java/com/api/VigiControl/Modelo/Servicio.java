package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"fecha", "personalID", "horarioID"})
})
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servicioID;
    private String nombre;
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "personalID")
    private Personal personalID;
    @ManyToOne
    @JoinColumn(name = "horarioID")
    private Horario horarioID;
    @OneToMany(mappedBy = "servicioTareaID")
    @JsonIgnore
    private List<ServicioTarea> servicioTareaList;
}
