package jp.co.gxp.spring_conditional_example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mock.env.MockEnvironment;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConditionWithMockEnvironmentTest {

    @Test
    void bean_not_defined_when_property_is_empty() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConditionConfig.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> applicationContext.getBean("mapWhenTestConditionEnabled", Map.class));
    }

    @Test
    void bean_available_when_property_set_true() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("app.key-for-test.first", "true");
        applicationContext.setEnvironment(mockEnvironment);
        applicationContext.register(TestConditionConfig.class);
        applicationContext.refresh();

        Map<?, ?> actual = applicationContext.getBean("mapWhenTestConditionEnabled", Map.class);
        assertEquals("value1", actual.get("key1"));
    }
}