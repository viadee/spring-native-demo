package com.example.demo.random;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.aot.DisabledInAotMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisabledInAotMode
public class RandomCallServiceInvokerTest {

    @Mock
    private RandomCallService1 randomCallService1;

    @Mock
    private RandomCallService2 randomCallService2;

    @InjectMocks
    private RandomCallServiceInvoker invoker;

    @Test
    void invokesService1_whenThresholdLessThanAnyRandom() {
        // arrange
        when(randomCallService1.call()).thenReturn("service1-called");

        // act
        String result = invoker.invokeRandomService(0.0);

        // assert
        assertEquals("service1-called", result);
        verify(randomCallService1, times(1)).call();
        verify(randomCallService2, never()).call();
    }

    @Test
    void invokesService2_whenThresholdAtOrAboveOne() {
        // arrange
        when(randomCallService2.call()).thenReturn("service2-called");

        // act
        String result = invoker.invokeRandomService(1.0);

        // assert
        assertEquals("service2-called", result);
        verify(randomCallService2, times(1)).call();
        verify(randomCallService1, never()).call();
    }
}
