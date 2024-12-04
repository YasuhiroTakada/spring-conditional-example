package jp.co.gxp.spring_conditional_example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConditionalOnProperty(prefix = "app.key-for-test", name = "second")
public class SecondConfig {

    @Bean
    public Map<String, String> mapWhenPropertySecondValueIsExists() {
        return Map.of("key2", "value2");
    }
}
