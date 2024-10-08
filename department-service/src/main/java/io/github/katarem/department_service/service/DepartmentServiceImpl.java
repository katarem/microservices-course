package io.github.katarem.department_service.service;

import io.github.katarem.department_service.dto.DepartmentDto;
import io.github.katarem.department_service.entity.Department;
import io.github.katarem.department_service.mapper.DepartmentMapper;
import io.github.katarem.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository repository;

    @Override
    public void insert(DepartmentDto dto) {
        Department department = DepartmentMapper.INSTANCE.dtoToDepartment(dto);
        repository.save(department);
    }

    @Override
    public DepartmentDto get(Long id) {
        Department department = repository.findById(id).orElseThrow();
        return DepartmentMapper.INSTANCE.departmentToDto(department);
    }

    @Override
    public List<DepartmentDto> getAll() {
        return repository.findAll().stream().map(DepartmentMapper.INSTANCE::departmentToDto).toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public DepartmentDto update(Long id, DepartmentDto departmentDto) {
        Department department = DepartmentMapper.INSTANCE.dtoToDepartment(departmentDto);
        repository.findById(id).orElseThrow();
        department.setId(id);
        repository.save(department);
        return departmentDto;
    }
}
