package com.api.VigiControl.Controlador;
import com.api.VigiControl.Config.SecurityConfig;
import com.api.VigiControl.Jwt.JwtService;
import com.api.VigiControl.Modelo.*;
import com.api.VigiControl.Servicio.PersonalService;
import com.api.VigiControl.TestConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collection;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(PersonalController.class)
@Import({SecurityConfig.class, TestConfig.class})
class PersonalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonalService personalService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private AuthenticationProvider authProvider;

    @Test
    @WithMockUser
    public void testBuscarPersonal() throws Exception{

        Personal personal = new Personal();
        personal.setPersonalID("ABCD1234");
        personal.setApeYnom("Prueba Prueba");
        personal.setCargo(1234);
        personal.setVisible(1);
        personal.setRolUsuarioID(new RolUsuario());
        personal.setUsername("prueba1234");
        personal.setPassword("kjdsfnalkjbsd<flajjdblf");

        when(personalService.buscarPersonal("ABCD1234")).thenReturn(personal);

        mockMvc.perform(get("/personal/listar/ABCD1234")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.personalID").value("ABCD1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.apeYnom").value("Prueba Prueba"));
    }

    @Test
    @WithMockUser
    public void testBuscarPersonal_NotFound() throws Exception {
        when(personalService.buscarPersonal("999")).thenThrow(new RuntimeException("Personal no encontrado"));

        mockMvc.perform(get("/personal/listar/999"))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());;
    }

    @Test
    @WithMockUser
    void ingresarPersona() throws Exception {
        Personal personal = new Personal();
        personal.setPersonalID("ABCD1234");
        personal.setApeYnom("Prueba Prueba");
        personal.setCargo(1234);
        personal.setVisible(1);
        personal.setRolUsuarioID(new RolUsuario());
        personal.setUsername("prueba1234");
        personal.setPassword("kjdsfnalkjbsd<flajjdblf");

        when(personalService.ingresarPersona(personal)).thenReturn(personal);

        mockMvc.perform(post("/personal/persona")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(personal)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.addMixIn(Personal.class, PersonalMixIn.class);
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    abstract class PersonalMixIn {
        @JsonIgnore
        abstract Collection<? extends GrantedAuthority> getAuthorities();
    }
}