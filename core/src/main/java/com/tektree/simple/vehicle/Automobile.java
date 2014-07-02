package com.tektree.simple.vehicle;

import java.math.BigDecimal;

public interface Automobile {
	
	int wheels = 4;
	
	String engineType();
	
	String driveType();
	
	Integer mileage();
	
	BigDecimal mpg();
	
	int getWheels();

}
