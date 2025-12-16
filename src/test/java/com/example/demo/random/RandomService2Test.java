package com.example.demo.random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RandomService2Test {

    @Autowired
    private RandomCallService2 randomCallService2;

    @Test
    void call_shouldReturnKopf() {
        String result = randomCallService2.call();
        assertThat(result).isEqualTo("Kopf");
    }

}
