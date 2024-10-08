package io.github.katarem.department_service.mapper;

import io.github.katarem.department_service.dto.DepartmentDto;
import io.github.katarem.department_service.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper{

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto departmentToDto(Department department);
    Department dtoToDepartment(DepartmentDto dto);
}
