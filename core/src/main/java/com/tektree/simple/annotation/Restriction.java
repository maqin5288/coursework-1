package com.tektree.simple.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value={FIELD, METHOD})
@Retention(value=SOURCE)
public @interface Restriction {
	
	int pattern();

}
