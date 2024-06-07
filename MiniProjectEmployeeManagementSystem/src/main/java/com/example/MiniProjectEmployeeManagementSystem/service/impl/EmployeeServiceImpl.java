package com.example.MiniProjectEmployeeManagementSystem.service.impl;
import com.example.MiniProjectEmployeeManagementSystem.dto.EmployeeDto;
import com.example.MiniProjectEmployeeManagementSystem.entity.Employee;
import com.example.MiniProjectEmployeeManagementSystem.exception.EmailAlreadyExistException;
import com.example.MiniProjectEmployeeManagementSystem.exception.ResourceNotFoundException;
import com.example.MiniProjectEmployeeManagementSystem.mapper.EmployeeMapper;
import com.example.MiniProjectEmployeeManagementSystem.repository.EmployeeRepository;
import com.example.MiniProjectEmployeeManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        Optional<Employee> optionalEmployee=employeeRepository.findByEmail(employee.getEmail());
        if(optionalEmployee.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist for Employee");
        }
        return EmployeeMapper.maptoEmployeeDto(employeeRepository.save(employee));

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map(employee->modelMapper.map(employee,EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee","id", employeeId));
        return modelMapper.map(employee,EmployeeDto.class);

    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee emp=employeeRepository.findById(employeeDto.getId())
                .orElseThrow(()->new ResourceNotFoundException("Employee","id", employeeDto.getId()));;
        emp.setFirstname(employeeDto.getFirstname());
        emp.setLastname(employeeDto.getLastname());
        emp.setEmail(employeeDto.getEmail());
        return modelMapper.map(employeeRepository.save(emp),EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
employeeRepository.deleteById(employeeId);
    }
}