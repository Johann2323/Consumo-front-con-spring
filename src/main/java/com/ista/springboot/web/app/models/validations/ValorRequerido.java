package com.ista.springboot.web.app.models.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorRequerido implements ConstraintValidator<ValidNum,Double> {

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if(value==null||value<0||value.isNaN()) {
			return false;
		}
		return true;
	}

}
