package com.leo.crud.vendas.validations;

import com.leo.crud.vendas.validations.constraints.ListNotNull;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ListNotNullValdiation implements ConstraintValidator<ListNotNull, List<?>> {

    @Override
    public void initialize(ListNotNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<?> s, ConstraintValidatorContext constraintValidatorContext) {

        if(s.isEmpty()) return false;

        return true;
    }
}
