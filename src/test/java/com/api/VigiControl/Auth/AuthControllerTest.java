package com.api.VigiControl.Auth;
import com.api.VigiControl.Config.SecurityConfig;
import com.api.VigiControl.Jwt.JwtService;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Modelo.RolUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@Import(SecurityConfig.class)
class AuthControllerTest {

    private LoginRequest loginRequest;
    private AuthResponse authResponse;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthService authService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private AuthenticationProvider authProvider;

    @BeforeEach
    void setUp() {
        loginRequest = new LoginRequest();
        loginRequest.setUsername("LUCIANO_ACS");
        loginRequest.setPassword("38243415VC");

        UserDetails userDetails = new User(loginRequest.getUsername(), loginRequest.getPassword(), new ArrayList<>());
        String token = jwtService.getToken(userDetails);

        authResponse = new AuthResponse();
        authResponse.setToken(token);

        when(authService.login(any(LoginRequest.class))).thenReturn(authResponse);
    }

    @Test
    void login() throws Exception {
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loginRequest)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").value(authResponse.getToken()));
    }

    @Test
    void register() throws Exception {
        Personal personal = new Personal();
        personal.setPersonalID("ABCD1234");
        personal.setApeYnom("Prueba Prueba");
        personal.setCargo(1234);
        personal.setVisible(1);
        personal.setRolUsuarioID(new RolUsuario());
        personal.setUsername("prueba1234");
        personal.setPassword("kjdsfnalkjbsd<flajjdblf");

        List<Personal> personalList = new ArrayList<>();
        personalList.add(personal);

        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(personalList)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.addMixIn(Personal.class, AuthControllerTest.PersonalMixIn.class);
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
