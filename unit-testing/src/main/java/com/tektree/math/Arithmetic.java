package com.tektree.math;

public class Arithmetic {

	public static Integer add(Integer arg1, Integer arg2) {
		if(arg1 == null || arg2 == null){
			throw new IllegalArgumentException("Cannot add if any of the parameters is null.");
		}
		return arg1 + arg2;
	}
	
	//TODO: Implement me!!!
	public static Integer subtract(Integer arg1, Integer arg2){
		return null;
	}

}
