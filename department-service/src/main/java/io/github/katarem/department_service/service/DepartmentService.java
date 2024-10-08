package io.github.katarem.department_service.service;

import io.github.katarem.department_service.dto.DepartmentDto;
import io.github.katarem.department_service.entity.Department;

import java.util.List;

public interface DepartmentService {
    void insert(DepartmentDto department);
    DepartmentDto get(Long id);
    List<DepartmentDto> getAll();
    void delete(Long id);
    DepartmentDto update(Long id, DepartmentDto department);
}
