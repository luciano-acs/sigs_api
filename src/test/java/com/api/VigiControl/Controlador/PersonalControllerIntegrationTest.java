package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Distrito;
import com.api.VigiControl.Modelo.Grado;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Servicio.PersonalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/cleanup-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class PersonalControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersonalService personalService;

    @Test
    @WithMockUser
    void actualizarPersonal() throws Exception {
        String personalId = "ABCD1234";

        //BUSQUEDA DE PERSONAL
        MvcResult mvcResult = mockMvc.perform(get("/personal/listar/{id}" , personalId)
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andDo(MockMvcResultHandlers.print())
                                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        Personal personalParaActualizar = objectMapper.readValue(jsonResponse, Personal.class);

        //MODIFICACION DE PERSONAL
        personalParaActualizar.setApeYnom("Nuevo nombre y apellido");

        //String personalActualizado = objectMapper.writeValueAsString(personalParaActualizar);

        //ACTUALIZACION DE PERSONAL
        mockMvc.perform(post("/personal/persona")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(personalParaActualizar)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}