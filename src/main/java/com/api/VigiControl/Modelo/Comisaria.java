package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comisaria {

    @Id
    private int comisariaID;
    private String nombre;
    @OneToOne
    private Domicilio domicilioID;
    @ManyToOne
    @JoinColumn(name = "distritoID")
    private Distrito distritoID;

    public int getComisariaID() {
        return comisariaID;
    }

    public void setComisariaID(int comisariaID) {
        this.comisariaID = comisariaID;
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

    public Distrito getDistritoID() {
        return distritoID;
    }

    public void setDistritoID(Distrito distritoID) {
        this.distritoID = distritoID;
    }
}
