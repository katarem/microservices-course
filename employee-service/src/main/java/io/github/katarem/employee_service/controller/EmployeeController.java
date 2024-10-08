package io.github.katarem.employee_service.controller;

import io.github.katarem.employee_service.dto.EmployeeDto;
import io.github.katarem.employee_service.mapper.EmployeeMapper;
import io.github.katarem.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id){
        EmployeeDto employeeDto = service.get(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> insertEmployee(@RequestBody EmployeeDto dto){
        EmployeeDto response = service.insert(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody EmployeeDto dto){

        EmployeeDto response = service.update(id, dto);
        return ResponseEntity.accepted().body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
