package com.example.watchlistapp.entity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PriorityAnnotationLogic implements ConstraintValidator<Priority, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return s.trim().length() == 1 && "LMH".contains(s.trim());
    }
}
