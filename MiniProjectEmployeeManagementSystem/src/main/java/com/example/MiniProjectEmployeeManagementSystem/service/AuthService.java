package com.example.MiniProjectEmployeeManagementSystem.service;

import com.example.MiniProjectEmployeeManagementSystem.dto.JwtAuthResponse;
import com.example.MiniProjectEmployeeManagementSystem.dto.LoginRequestDto;
import com.example.MiniProjectEmployeeManagementSystem.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
   JwtAuthResponse login(LoginRequestDto loginRequestDto);
}
