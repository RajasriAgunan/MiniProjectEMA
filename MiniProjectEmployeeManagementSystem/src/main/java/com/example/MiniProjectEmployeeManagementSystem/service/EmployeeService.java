package com.example.MiniProjectEmployeeManagementSystem.service;

import com.example.MiniProjectEmployeeManagementSystem.dto.EmployeeDto;
import com.example.MiniProjectEmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployee(Long employeeId);


    EmployeeDto updateEmployee(EmployeeDto employeeDto);


    void deleteEmployee(Long employeeId);
}
