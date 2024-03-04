package com.api.VigiControl.Auth;

import com.api.VigiControl.Jwt.JwtService;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Repositorio.IPersonalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private IPersonalRepo personalRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails personal = personalRepo.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(personal);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);

        return authResponse;
    }
    public AuthResponse register(RegisterRequest request) {
        Personal personal = new Personal();
        personal.setPersonalID(request.getPersonalID());
        personal.setApeYnom(request.getApeYnom());
        personal.setVisible(request.getVisible());
        personal.setCargo(request.getCargo());
        personal.setGradoID(request.getGradoID());
        personal.setComisariaID(request.getComisariaID());
        personal.setDistritoID(request.getDistritoID());
        personal.setDomicilioID(request.getDomicilioID());
        personal.setRolUsuarioID(request.getRolUsuarioID());
        personal.setUsername(request.getUsername());
        personal.setPassword(passwordEncoder.encode(request.getPassword()));

        personalRepo.save(personal);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtService.getToken(personal));

        return authResponse;
    }
}
