package com.tektree.simple.math;

import java.lang.reflect.Method;
import java.math.BigDecimal;

@SuppressWarnings("unchecked")
public class Arithmetic <T extends Number> {
	
	public static <T extends Number> T addStatically(T arg1, T arg2) {
		BigDecimal result = new BigDecimal(arg1.toString()).add(new BigDecimal(
				arg2.toString()));
		try {
			Method valueOf = arg1.getClass().getMethod("valueOf", String.class);
			return (T) valueOf.invoke(arg1, result.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal arguments passed in.", e);
		}
	}

	public T add(T arg1, T arg2){
		BigDecimal result = new BigDecimal(arg1.toString()).add(new BigDecimal(
				arg2.toString()));
		try {
			Method valueOf = arg1.getClass().getMethod("valueOf", String.class);
			return (T) valueOf.invoke(arg1, result.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal arguments passed in.", e);
		}
	}
	
	public T subtract(T arg1, T arg2){
		BigDecimal result = new BigDecimal(arg1.toString()).subtract(new BigDecimal(
				arg2.toString()));
		try {
			Method valueOf = arg1.getClass().getMethod("valueOf", String.class);
			return (T) valueOf.invoke(arg1, result.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal arguments passed in.", e);
		}
	}

}
