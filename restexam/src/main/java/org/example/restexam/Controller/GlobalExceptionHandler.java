package org.example.restexam.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice -- html기반으로 만들어진 view
@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Runtime Error: "+ ex.getMessage());

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleRResourceNotFoundException(ResourceNotFoundException  e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("ResourceNotFoundException Error: "+ e.getMessage());
    }
    }

//    @ExceptionHandler(ErrorTestController.ResourceNotFoundException.class)
//    public ResponseEntity<String> handleRResourceNotFoundException(ErrorTestController.ResourceNotFoundException ex){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("ResourceNotFoundException Error: "+ ex.getMessage());
//    }

