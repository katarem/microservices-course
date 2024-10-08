package io.github.katarem.employee_service.exception;

import io.github.katarem.employee_service.service.ResouceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalException(Exception exception,
                                                        WebRequest request
    ){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),request.getDescription(false),"SERVER_ERROR");
        return ResponseEntity.internalServerError().body(errorDetails);
    }

    @ExceptionHandler(ResouceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFound(ResouceNotFoundException exception,
                                                         WebRequest request
    ){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), request.getDescription(false), "RESOUCE_NOT_FOUND");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

}
