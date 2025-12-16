package com.example.demo.greeting;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private static final String TEMPLATE = "Hello, %s!";

    private final AtomicLong counter;

    public GreetingService() {
        this.counter = new AtomicLong();
    }

    public Greeting greeting(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
