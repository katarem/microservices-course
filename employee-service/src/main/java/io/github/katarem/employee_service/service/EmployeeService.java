package io.github.katarem.employee_service.service;

import io.github.katarem.employee_service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAll();
    EmployeeDto getById(Long id) throws ResouceNotFoundException;
    EmployeeDto insert(EmployeeDto dto);
    EmployeeDto update(Long id, EmployeeDto dto);
    void delete(Long id);
}
