package com.leo.crud.vendas.validations.constraints;

import com.leo.crud.vendas.validations.DateNotExceedingValidation;
import com.leo.crud.vendas.validations.ListNotNullValdiation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListNotNullValdiation.class)
public @interface ListNotNull {

    String message() default "date cannot be greater than current date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
