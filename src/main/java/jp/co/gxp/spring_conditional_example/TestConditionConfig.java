package jp.co.gxp.spring_conditional_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Conditional(TestFirstCondition.class)
public class TestConditionConfig {

    @Bean
    public Map<String, String> mapWhenTestConditionEnabled() {
        return Map.of("key1", "value1");
    }
}
