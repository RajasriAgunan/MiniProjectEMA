package com.example.MiniProjectEmployeeManagementSystem.controller;

import com.example.MiniProjectEmployeeManagementSystem.dto.JwtAuthResponse;
import com.example.MiniProjectEmployeeManagementSystem.dto.LoginRequestDto;
import com.example.MiniProjectEmployeeManagementSystem.dto.RegisterDto;
import com.example.MiniProjectEmployeeManagementSystem.service.AuthService;
import jdk.jfr.Registered;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class Authcontroller {

    private AuthService authService;

    @PostMapping("login")

    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginRequestDto requestDto) {
        JwtAuthResponse jwtAuthResponse = authService.login(requestDto);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto requestDto) {
        String response = authService.register(requestDto);
        return ResponseEntity.ok(response);
    }
}