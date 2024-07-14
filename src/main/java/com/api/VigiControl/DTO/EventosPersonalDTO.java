package com.api.VigiControl.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventosPersonalDTO {

    private String nombreDistrito;
    private String nombreTarea;
    private Long cantidadTarea;

}
