package com.aakin.employeeservice.dto.converter;

import com.aakin.employeeservice.dto.EmployeeDto;
import com.aakin.employeeservice.entity.Employee;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    public EmployeeDto convert(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .email(employee.getEmail())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .build();
    }
}
