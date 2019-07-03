package com.jialing.swift.flux.validation.constraint;

import com.jialing.swift.flux.validation.ValidCardNumber;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberConstraintValidator implements ConstraintValidator<ValidCardNumber, String> {


    @Override
    public void initialize(ValidCardNumber validCardNumber) {

    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String[] splits = StringUtils.delimitedListToStringArray(s, "-");
        if (splits.length != 2) {
            return false;
        }
        return true;
    }


}
