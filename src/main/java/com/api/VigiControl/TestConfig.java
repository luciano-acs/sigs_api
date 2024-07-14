package com.api.VigiControl;

import com.api.VigiControl.Modelo.Personal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Personal.class, PersonalMixIn.class);
        return mapper;
    }
}
