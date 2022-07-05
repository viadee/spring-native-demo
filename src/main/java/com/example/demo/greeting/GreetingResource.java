package com.example.demo.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingResource {

    private final GreetingService greetingService;

    public GreetingResource(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public Greeting get(@RequestParam(value = "name", defaultValue = "World")  String name) {
        return greetingService.greeting(name);
    }
}
