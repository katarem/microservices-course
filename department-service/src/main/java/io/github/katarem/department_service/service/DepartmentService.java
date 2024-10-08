package io.github.katarem.department_service.service;

import io.github.katarem.department_service.dto.DepartmentDto;
import io.github.katarem.department_service.entity.Department;
import io.github.katarem.department_service.exception.ResourceNotFoundException;

import java.util.List;

public interface DepartmentService {
    void insert(DepartmentDto department);
    DepartmentDto get(Long id);
    DepartmentDto getDepartmentByCode(String code) throws ResourceNotFoundException;
    List<DepartmentDto> getAll();
    void delete(Long id);
    DepartmentDto update(Long id, DepartmentDto department);
}
