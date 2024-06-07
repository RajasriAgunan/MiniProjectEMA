package com.example.MiniProjectEmployeeManagementSystem.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "Firstname must not be empty")
    private String firstname;
    @NotEmpty(message = "Lastname must not be empty")
    private String lastname;
    @NotEmpty(message = "Email must not be empty")
    @Email
    private String email;
}


