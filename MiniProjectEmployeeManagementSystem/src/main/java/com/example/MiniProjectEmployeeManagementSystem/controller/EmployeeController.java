package com.example.MiniProjectEmployeeManagementSystem.controller;

import com.example.MiniProjectEmployeeManagementSystem.dto.EmployeeDto;
import com.example.MiniProjectEmployeeManagementSystem.dto.LoginRequestDto;
import com.example.MiniProjectEmployeeManagementSystem.entity.Employee;
import com.example.MiniProjectEmployeeManagementSystem.security.JwtUtil;
import com.example.MiniProjectEmployeeManagementSystem.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name="CRUD API's for user resource",
description="CRUD API's-create user,update user,get user,get all users,delete user")
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

   // @PostMapping("login")
  //  public ResponseEntity<String> login(@RequestBody LoginRequestDto requestDto) {
    //    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
      //          requestDto.getUsername(),
        //        requestDto.getPassword()
       // );
       // authenticationManager.authenticate(token);
       // String jwt = jwtUtil.generate(requestDto.getUsername());
       // return ResponseEntity.ok(jwt);
   // }

@Operation(summary = "Create a new employee")

@PreAuthorize("hasRole(\"ADMIN\")")
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto saveEmp = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
    }
    @Operation(summary = "Get all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the employees",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employees not found",
                    content = @Content) })

    @PreAuthorize("hasAnyRole(\"ADMIN\",\"USER\")")
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return  ResponseEntity.ok().body(employees);
    }

    @Operation(summary = "Get an employee by ID")

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployee(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    @Operation(summary = "Update an employee")

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id
            ,@RequestBody @Valid EmployeeDto employeeDto) {
        employeeDto.setId(id);
        EmployeeDto updateEmployee = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @Operation(summary = "Delete an employee")

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

}