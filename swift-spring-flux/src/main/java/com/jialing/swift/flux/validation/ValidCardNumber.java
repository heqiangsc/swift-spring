package com.jialing.swift.flux.validation;

import com.jialing.swift.flux.validation.constraint.CardNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {CardNumberConstraintValidator.class})
public @interface ValidCardNumber   {

    boolean require() default true;

    String message() default "卡号不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
