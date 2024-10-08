package io.github.katarem.department_service.controller;

import io.github.katarem.department_service.dto.DepartmentDto;
import io.github.katarem.department_service.exception.ResourceNotFoundException;
import io.github.katarem.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/code/{departmentCode}")
    public ResponseEntity<DepartmentDto> getByDepartmentCode(@PathVariable("departmentCode") String departmentCode) throws ResourceNotFoundException {
        DepartmentDto found = service.getDepartmentByCode(departmentCode);
        return ResponseEntity.ok(found);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> insert(@RequestBody DepartmentDto departmentDto){
        service.insert(departmentDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentDto departmentDto,
                                                @PathVariable("id") Long id){
        DepartmentDto updated = service.update(id, departmentDto);
        return ResponseEntity.accepted().body(updated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DepartmentDto> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
