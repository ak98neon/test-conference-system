package com.redhash.conference.service.validation;

import com.redhash.conference.service.validation.validator.UniqueConferenceValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

@Documented
@Target({FIELD, ANNOTATION_TYPE, PARAMETER, TYPE_USE, METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Constraint(validatedBy = UniqueConferenceValidator.class)
public @interface UniqueConference {

    String message() default "Conference with this name already exists";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
