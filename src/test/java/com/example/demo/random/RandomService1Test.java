package com.example.demo.random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RandomService1Test {

    @Autowired
    private RandomCallService1 randomCallService1;

    @Test
    void call_shouldReturnZahl() {
        String result = randomCallService1.call();
        assertThat(result).isEqualTo("Zahl");
    }

}
