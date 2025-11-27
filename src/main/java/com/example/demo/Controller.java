package com.example.demo;

import com.example.demo.greeting.Greeting;
import com.example.demo.greeting.GreetingService;
import com.example.demo.random.RandomCallServiceInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final GreetingService greetingService;
    private final RandomCallServiceInvoker randomCallServiceInvoker;

    @Autowired
    public Controller(final GreetingService greetingService, final RandomCallServiceInvoker randomCallServiceInvoker) {
        this.randomCallServiceInvoker = randomCallServiceInvoker;
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public String redirectToGreeting() {
        return "redirect:/greeting";
    }

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World")  String name) {
        return greetingService.greeting(name);
    }

    @GetMapping("/random")
    public String getRandomGreeting(@RequestParam(value = "threshold", defaultValue = "0.5")  double threshold) {
        return randomCallServiceInvoker.invokeRandomService(threshold);
    }

}
