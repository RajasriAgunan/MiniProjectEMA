package com.example.MiniProjectEmployeeManagementSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@AllArgsConstructor
public class EmployeeAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
