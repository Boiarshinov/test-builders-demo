package dev.boiarshinov.testbuildersdemo.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = InnHashValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInnHash {

    String message() default "Invalid INN";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
