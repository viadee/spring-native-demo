package com.example.demo.config;

import com.example.demo.random.RandomCallService1;
import com.example.demo.random.RandomCallService2;
import com.example.demo.random.RandomCallServiceInvoker;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class NativeReflectionRuntimeHintConfig implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {

        hints.reflection().registerType(RandomCallService1.class, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(RandomCallService2.class, MemberCategory.INVOKE_PUBLIC_METHODS);
        hints.reflection().registerType(RandomCallServiceInvoker.class, MemberCategory.INVOKE_PUBLIC_METHODS);

    }

}
