package io.github.katarem.employee_service.mapper;

import io.github.katarem.employee_service.dto.EmployeeDto;
import io.github.katarem.employee_service.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    public static EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeToDto(Employee employee);
    Employee dtoToEmployee(EmployeeDto dto);
}
