package com.aakin.departmentservice.service;

import com.aakin.departmentservice.dto.DepartmentDto;
import com.aakin.departmentservice.dto.converter.DepartmentConverter;
import com.aakin.departmentservice.dto.request.DepartmentRequest;
import com.aakin.departmentservice.entity.Department;
import com.aakin.departmentservice.exception.DepartmentCodeAlreadyExistsException;
import com.aakin.departmentservice.exception.ResourceNotFoundException;
import com.aakin.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentConverter departmentConverter;

    public DepartmentDto saveDepartment(DepartmentRequest departmentRequest){
        Department department = new Department(
                departmentRequest.getId(),
                departmentRequest.getDepartmentName(),
                departmentRequest.getDepartmentDescription(),
                departmentRequest.getDepartmentCode()
        );

        Optional<Department> optionalDepartmentCode = departmentRepository.findByDepartmentCode(department.getDepartmentCode());
        if(optionalDepartmentCode.isPresent()){
            throw new DepartmentCodeAlreadyExistsException("Department Code is already exist");
        }

        departmentRepository.save(department);
        return departmentConverter.convertDto(department);
    }

    public DepartmentDto getDepartmentByCode(String code){
        return departmentRepository.findByDepartmentCode(code)
                .map(departmentConverter::convertDto).orElseThrow(() -> new ResourceNotFoundException("Department", "Code", code));
    }

}

