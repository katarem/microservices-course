package io.github.katarem.employee_service.service;

public class ResouceNotFoundException extends Exception {

    private String resourceName;
    private String field;
    private Long value;

    public ResouceNotFoundException(String resourceName, String field, Long value){
        super(String.format("%s not found with %s = '%s'",resourceName,field,value));
        this.resourceName = resourceName;
        this.field = field;
        this.value = value;
    }
}
