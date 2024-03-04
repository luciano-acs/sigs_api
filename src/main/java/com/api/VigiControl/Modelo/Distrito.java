package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Distrito {

    @Id
    private int distritoID;
    private String nombre;
    @OneToOne
    private Domicilio domicilioID;
    @OneToMany(mappedBy = "distritoID")
    @JsonIgnore
    private List<Comisaria> comisarias;
    @OneToMany(mappedBy = "distritoID")
    @JsonIgnore
    private List<Personal> personal;

    public int getDistritoID() {
        return distritoID;
    }

    public void setDistritoID(int distritoID) {
        this.distritoID = distritoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilioID() {
        return domicilioID;
    }

    public void setDomicilioID(Domicilio domicilioID) {
        this.domicilioID = domicilioID;
    }

    public List<Comisaria> getComisarias() {
        return comisarias;
    }

    public void setComisarias(List<Comisaria> comisarias) {
        this.comisarias = comisarias;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }
}
