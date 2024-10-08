package io.github.katarem.employee_service.service;

import io.github.katarem.employee_service.dto.EmployeeDto;
import io.github.katarem.employee_service.entity.Employee;
import io.github.katarem.employee_service.mapper.EmployeeMapper;
import io.github.katarem.employee_service.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    @Override
    public List<EmployeeDto> getAll() {
        return repository.findAll().stream().map(mapper::employeeToDto).toList();
    }

    @Override
    public EmployeeDto get(Long id) {
        Employee employee = repository.findById(id).orElseThrow();
        return mapper.employeeToDto(employee);
    }

    @Override
    public EmployeeDto insert(EmployeeDto dto) {
        Employee employee = mapper.dtoToEmployee(dto);
        repository.save(employee);
        return mapper.employeeToDto(employee);
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto dto) {
        repository.findById(id).orElseThrow();
        dto.setId(id); // por si acaso
        Employee employee = mapper.dtoToEmployee(dto);
        repository.save(employee);
        return dto;
    }

    @Override
    public void delete(Long id) {
        Employee employee = repository.findById(id).orElseThrow();
        repository.delete(employee);
    }
}
