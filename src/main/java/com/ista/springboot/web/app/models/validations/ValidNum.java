package com.ista.springboot.web.app.models.validations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValorRequerido.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface ValidNum {
	String message() default "El valor no puede ser negativo";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
