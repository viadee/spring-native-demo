package com.example.demo.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class RandomCallServiceInvoker {

    private final RandomCallService1 randomCallService1;
    private final RandomCallService2 randomCallService2;

    @Autowired
    public RandomCallServiceInvoker(RandomCallService1 randomCallService1, RandomCallService2 randomCallService2) {
        this.randomCallService1 = randomCallService1;
        this.randomCallService2 = randomCallService2;
    }

    // Artificial use of reflections
    public String invokeRandomService(double randomThreshold) {
        String randomServiceToCall;
        if (Math.random() > randomThreshold) {
            randomServiceToCall = "com.example.demo.random.RandomCallService1";
        } else {
            randomServiceToCall = "com.example.demo.random.RandomCallService2";
        }

        try {
            // Resolved at runtime -> needs to be registered
            Class<?> randomClass = Class.forName(randomServiceToCall);
            Method method = randomClass.getMethod("call");
            Object instance = randomClass.equals(RandomCallService1.class) ? randomCallService1 : randomCallService2;
            return (String) method.invoke(instance);
        } catch (Exception e) {
            return "Error while invoking service: " + e.getMessage();
        }
    }
}

