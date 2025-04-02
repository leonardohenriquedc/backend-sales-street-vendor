package com.leo.crud.vendas.validations;

import com.leo.crud.vendas.validations.constraints.DateNotExceeding;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateNotExceedingValidation implements ConstraintValidator<DateNotExceeding, LocalDate> {
    @Override
    public void initialize(DateNotExceeding constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {

        if(localDate == null) return false;

        LocalDate dateNow = LocalDate.now();

        return !localDate.isAfter(dateNow);
    }
}
