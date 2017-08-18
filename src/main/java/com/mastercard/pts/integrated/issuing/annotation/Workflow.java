package com.mastercard.pts.integrated.issuing.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * Marks classes which contains workflow steps. Execution of all public methods are 
 * reported as nested steps. 
 * @author Vitaliy Liubezny
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Workflow {
}
