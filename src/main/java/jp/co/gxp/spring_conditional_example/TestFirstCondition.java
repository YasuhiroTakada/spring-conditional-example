package jp.co.gxp.spring_conditional_example;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TestFirstCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
         return context
                 .getEnvironment()
                 .getProperty("app.key-for-test.first", Boolean.class,Boolean.FALSE);
    }
}
