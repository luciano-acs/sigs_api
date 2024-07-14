package com.api.VigiControl.Auth;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<List<AuthResponse>> register(@RequestBody List<RegisterRequest> requests) {
        List<AuthResponse> responses = new ArrayList<>();
        for (RegisterRequest request : requests) {
            AuthResponse response = authService.register(request);
            responses.add(response);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }
}
