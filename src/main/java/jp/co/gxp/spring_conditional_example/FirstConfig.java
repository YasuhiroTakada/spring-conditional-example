package jp.co.gxp.spring_conditional_example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConditionalOnProperty(prefix = "app.key-for-test", name = "first", havingValue = "true")
public class FirstConfig {

    @Bean
    public Map<String, String> mapWhenPropertyFirstValueIsTrue() {
        return Map.of("key1", "value1");
    }
}
