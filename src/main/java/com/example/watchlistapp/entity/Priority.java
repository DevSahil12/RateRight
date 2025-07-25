package com.example.watchlistapp.entity;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityAnnotationLogic.class)
public @interface Priority {
    String message() default "Kindly enter L,M,H only";
    Class<?>[] groups() default {
        
    };
    Class<? extends Payload>[] payload() default {
        
    };
}
