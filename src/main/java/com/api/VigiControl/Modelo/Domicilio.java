package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int domicilioID;
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "localidadId")
    private Localidad localidadID;
    @OneToMany(mappedBy = "domicilioID")
    @JsonIgnore
    private List<Personal> personal;

    public int getDomicilioID() {
        return domicilioID;
    }

    public void setDomicilioID(int domicilioID) {
        this.domicilioID = domicilioID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Localidad getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(Localidad localidadID) {
        this.localidadID = localidadID;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }
}
