package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
}
