package com.aakin.departmentservice.controller;

import com.aakin.departmentservice.dto.DepartmentDto;
import com.aakin.departmentservice.dto.request.DepartmentRequest;
import com.aakin.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody  DepartmentRequest departmentRequest){
        return ResponseEntity.ok(departmentService.saveDepartment(departmentRequest));
    }
    @GetMapping("{departmentcode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String departmentcode){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentcode));
    }
}
