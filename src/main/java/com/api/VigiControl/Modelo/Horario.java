package com.api.VigiControl.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.sql.Time;
import java.util.List;

@Entity
public class Horario {

    @Id
    private int horarioID;
    private String nombre;
    private Time horarioInicio;
    private Time horarioFin;
    @OneToMany(mappedBy = "servicioID")
    private List<Servicio> servicioList;

    public int getHorarioID() {
        return horarioID;
    }

    public void setHorarioID(int horarioID) {
        this.horarioID = horarioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(Time horarioFin) {
        this.horarioFin = horarioFin;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }
}
