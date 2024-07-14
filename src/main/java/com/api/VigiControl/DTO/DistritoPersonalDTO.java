package com.api.VigiControl.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistritoPersonalDTO {

    private String distrito;
    private Long cantidadPersonal;
}
