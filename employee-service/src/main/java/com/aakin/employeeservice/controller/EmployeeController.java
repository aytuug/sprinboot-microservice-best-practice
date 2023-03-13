package com.aakin.employeeservice.controller;

import com.aakin.employeeservice.dto.EmployeeDto;
import com.aakin.employeeservice.dto.request.EmployeeRequest;
import com.aakin.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

}
