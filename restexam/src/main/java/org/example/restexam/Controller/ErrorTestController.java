package org.example.restexam.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestController {
    @GetMapping("/api/errtest")
    public ResponseEntity<String> test() {
//        throw new RuntimeException("test");
        throw new ResourceNotFoundException("resourceNotFoundException");

    }
}
