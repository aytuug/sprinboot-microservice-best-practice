package com.aakin.departmentservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
