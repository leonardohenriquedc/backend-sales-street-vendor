package com.leo.crud.vendas.validations.constraints;

import com.leo.crud.vendas.validations.DateNotExceedingValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateNotExceedingValidation.class)
public @interface DateNotExceeding {

    String message() default "date cannot be greater than current date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
