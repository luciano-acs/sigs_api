package com.api.VigiControl.Modelo;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
public class ServicioTarea {

    @Id
    private int servicioTareaID;
    private Date fecha;
    private Time hora;
    @ManyToOne
    @JoinColumn(name = "servicioID")
    private Servicio servivioID;
    @ManyToOne
    @JoinColumn(name = "tareaID")
    private Tarea tareaID;

    public int getServicioTareaID() {
        return servicioTareaID;
    }

    public void setServicioTareaID(int servicioTareaID) {
        this.servicioTareaID = servicioTareaID;
    }

    public Servicio getServivioID() {
        return servivioID;
    }

    public void setServivioID(Servicio servivioID) {
        this.servivioID = servivioID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Tarea getTareaID() {
        return tareaID;
    }

    public void setTareaID(Tarea tareaID) {
        this.tareaID = tareaID;
    }
}
