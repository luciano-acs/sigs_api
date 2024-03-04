package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Servicio {

    @Id
    private int servicioID;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "personalID")
    private Personal personalID;
    @ManyToOne
    @JoinColumn(name = "horarioID")
    private Horario horarioID;
    @OneToMany(mappedBy = "servicioTareaID")
    @JsonIgnore
    private List<ServicioTarea> servicioTareaList;

    public int getServicioID() {
        return servicioID;
    }

    public void setServicioID(int servicioID) {
        this.servicioID = servicioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Personal getPersonalID() {
        return personalID;
    }

    public void setPersonalID(Personal personalID) {
        this.personalID = personalID;
    }

    public List<ServicioTarea> getServicioTareaList() {
        return servicioTareaList;
    }

    public void setServicioTareaList(List<ServicioTarea> servicioTareaList) {
        this.servicioTareaList = servicioTareaList;
    }
}
