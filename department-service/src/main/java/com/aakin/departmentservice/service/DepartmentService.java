package com.aakin.departmentservice.service;

import com.aakin.departmentservice.dto.DepartmentDto;
import com.aakin.departmentservice.dto.converter.DepartmentConverter;
import com.aakin.departmentservice.dto.request.DepartmentRequest;
import com.aakin.departmentservice.entity.Department;
import com.aakin.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        departmentRepository.save(department);
        return departmentConverter.convertDto(department);
    }

    public DepartmentDto getDepartmentByCode(String code){
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription()
        );

        return departmentDto;
    }

}
