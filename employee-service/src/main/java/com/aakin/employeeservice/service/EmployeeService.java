package com.aakin.employeeservice.service;

import com.aakin.employeeservice.dto.EmployeeDto;
import com.aakin.employeeservice.dto.converter.EmployeeConverter;
import com.aakin.employeeservice.dto.request.EmployeeRequest;
import com.aakin.employeeservice.entity.Employee;
import com.aakin.employeeservice.exception.EmailAlreadyExistException;
import com.aakin.employeeservice.exception.ResourceNotFoundException;
import com.aakin.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;
    public EmployeeDto saveEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee(
                employeeRequest.getId(),
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail()
        );
        Optional<Employee> emailOptional = employeeRepository.findByEmail(employee.getEmail());
        if(emailOptional.isPresent()){
            throw new EmailAlreadyExistException("Email already exist!");
        }
        employeeRepository.save(employee);
        return employeeConverter.convert(employee);
    }


    public EmployeeDto getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .map(employeeConverter::convert).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }
}
