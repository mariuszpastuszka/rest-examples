package com.example.exceptionhandling;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionRestController {

    @GetMapping("/safe-method")
    public void notFunny() {
        throw new RuntimeException(":)");
    }
}
