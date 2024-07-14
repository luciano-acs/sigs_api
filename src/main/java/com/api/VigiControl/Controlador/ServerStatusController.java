package com.api.VigiControl.Controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServerStatusController {

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> checkServerStatus() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "El servidor está en línea.");
        return ResponseEntity.ok(response);
    }
}
