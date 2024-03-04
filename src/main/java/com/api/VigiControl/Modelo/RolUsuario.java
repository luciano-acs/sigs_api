package com.api.VigiControl.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RolUsuario {

    @Id
    private int rolUsuarioID;
    private String descripcion;
    @OneToMany(mappedBy = "rolUsuarioID")
    @JsonIgnore
    private List<RolUsuario> rolUsuarios;
}
