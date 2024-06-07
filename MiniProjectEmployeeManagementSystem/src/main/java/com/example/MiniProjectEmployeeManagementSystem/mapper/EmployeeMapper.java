package com.example.MiniProjectEmployeeManagementSystem.mapper;
import com.example.MiniProjectEmployeeManagementSystem.dto.EmployeeDto;
import com.example.MiniProjectEmployeeManagementSystem.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto maptoEmployeeDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstname(employee.getFirstname());
        employeeDto.setLastname(employee.getLastname());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }
    public static Employee maptoEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstname(employeeDto.getFirstname());
        employee.setLastname(employeeDto.getLastname());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

}
