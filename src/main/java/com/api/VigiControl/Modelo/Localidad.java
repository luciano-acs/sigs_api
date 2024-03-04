package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Localidad {

    @Id
    private int localidadID;
    private String nombre;
    @OneToMany(mappedBy = "localidadID")
    @JsonIgnore
    private List<Domicilio> domicilios;

    public int getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(int localidadID) {
        this.localidadID = localidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
}
