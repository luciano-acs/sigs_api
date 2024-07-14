package com.api.VigiControl.Request;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBusquedaServicio {
    private String nombre;
    //@JsonDeserialize(converter = DateDeseliarizador.class)
    @Column(columnDefinition = "DATE")
    private LocalDate fecha;
}
