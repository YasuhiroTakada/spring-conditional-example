package jp.co.gxp.spring_conditional_example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {FirstConfig.class, SecondConfig.class})
public class ConfigTestWithPropertySourceTest {

    @Nested
    @TestPropertySource(properties = {"app.key-for-test.first=false"})
    public class FirstConfigTestEmpty {

        @Autowired
        private ApplicationContext context;

        @Test
        void first_is_not_exists_when_property_is_empty() {
            Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()-> context.getBean("mapWhenPropertyFirstValueIsTrue"));
        }

    }

    @Nested
    @TestPropertySource(properties = {"app.key-for-test.first=true"})
    public class FirstConfigTestExists {

        @Autowired
        private ApplicationContext context;

        @Test
        void first_is_enable_on_property_is_true() {
            Map<?, ?> map = context.getBean("mapWhenPropertyFirstValueIsTrue", Map.class);
            assertEquals("value1", map.get("key1"));
        }

    }

    @Nested
    @TestPropertySource(properties = {"app.key-for-test.second"})
    public class SecondConfigTest {

        @Autowired
        private ApplicationContext context;

        @Test
        void second_is_enable_when_property_exists() {
            Map<?, ?> map2 = context.getBean("mapWhenPropertySecondValueIsExists", Map.class);
            assertEquals("value2", map2.get("key2"));
        }

    }

}
