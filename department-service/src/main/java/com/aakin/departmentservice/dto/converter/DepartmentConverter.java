package com.aakin.departmentservice.dto.converter;

import com.aakin.departmentservice.dto.DepartmentDto;
import com.aakin.departmentservice.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {
    public DepartmentDto convertDto(Department department){
        return DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .departmentCode(department.getDepartmentCode())
                .build();

    }
}
