package com.jialing.swift.flux.validation.constraint;

import com.jialing.swift.flux.validation.ValidCardNumber;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberConstraintValidator implements ConstraintValidator<ValidCardNumber, String> {

    private boolean require = false;

    @Override
    public void initialize(ValidCardNumber validCardNumber) {
        require = validCardNumber.require();
    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (require) {
            return validCardNumber(s);
        } else {
            if (StringUtils.isEmpty(s)) {
                return true;
            } else {
                return validCardNumber(s);
            }
        }
    }

    private boolean validCardNumber(String s) {
        String[] splits = StringUtils.delimitedListToStringArray(s, "-");
        if (splits.length != 2) {
            return false;
        }
        return true;
    }


}
