package com.tektree.simple.vehicle;

import java.math.BigDecimal;

public abstract class Car implements Automobile {
	
	public abstract String engineType();
	
	public String driveType() {
		return "FWD";
	}
	
	public Integer mileage() {
		return 110000;
	}
	
	public BigDecimal mpg() {
		return new BigDecimal("30.00");
	}
	
	public int getWheels(){
		return wheels;
	}
	
}
