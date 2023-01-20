package de.viadee.spring_native_demo.greeting;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
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
