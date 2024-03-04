package com.api.VigiControl.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tarea {

    @Id
    @Column(length = 3)
    private String tareaID;
    private String nombre;
    @OneToMany(mappedBy = "servicioTareaID")
    private List<ServicioTarea> servicioTareasList;

    public String getTareaID() {
        return tareaID;
    }

    public void setTareaID(String tareaID) {
        this.tareaID = tareaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ServicioTarea> getPersonalTareasList() {
        return servicioTareasList;
    }

    public void setPersonalTareasList(List<ServicioTarea> servicioTareasList) {
        this.servicioTareasList = servicioTareasList;
    }
}
