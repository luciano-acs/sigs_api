package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.*;
import com.api.VigiControl.Repositorio.IPersonalRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonalServiceTest {

    private String id = "prueba1234";
    @Mock
    private IPersonalRepo personalRepo;

    @InjectMocks
    private PersonalService personalService;

    private Personal personal;

    @BeforeEach
    void setUp() {
        //INICIALIZAR MOCKITO
        MockitoAnnotations.initMocks(this);

        personal = new Personal();
        personal.setPersonalID("ABCD1234");
        personal.setApeYnom("Prueba Prueba");
        personal.setCargo(1234);
        personal.setVisible(1);
        personal.setGradoID(new Grado());
        personal.setComisariaID(new Comisaria());
        personal.setDomicilioID(new Domicilio());
        personal.setDistritoID(new Distrito());
        personal.setRolUsuarioID(new RolUsuario());
        personal.setUsername("prueba1234");
        personal.setPassword("kjdsfnalkjbsd<flajjdblf");
    }

    @Test
    void buscarPersonal() {
        when(personalRepo.findById(id)).thenReturn(Optional.ofNullable(personal));
        assertNotNull(personalService.buscarPersonal(id));
    }

    @Test
    void ingresarPersona() {
        when(personalRepo.save(personal)).thenReturn(personal);
        assertNotNull(personalService.ingresarPersona(personal));
    }
}