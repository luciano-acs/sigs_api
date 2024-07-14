package com.api.VigiControl.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"servicioID"})
})
public class ServicioTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servicioTareaID = 0;
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
    private Time hora;
    @ManyToOne
    @JoinColumn(name = "servicioID")
    private Servicio servicioID;
    @ManyToOne
    @JoinColumn(name = "tareaID")
    private Tarea tareaID;
}
