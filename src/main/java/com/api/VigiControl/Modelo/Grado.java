package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gradoID;
    private String grado;
    @OneToMany(mappedBy = "gradoID")
    @JsonIgnore
    private List<Personal> personal;

    public Integer getGradoID() {
        return gradoID;
    }

    public void setGradoID(Integer gradoID) {
        this.gradoID = gradoID;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(List<Personal> personal) {
        this.personal = personal;
    }
}
