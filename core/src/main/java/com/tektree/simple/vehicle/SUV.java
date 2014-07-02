package com.tektree.simple.vehicle;

public class SUV extends Car {

	@Override
	public String engineType() {
		return "V8";
	}
	
	@Override
	public String driveType() {
		return "4x4";
	}
	
	@Override
	public Integer mileage() {
		return super.mileage() + 50000;
	}
	
	public void drive() {
		System.out.println("Driving...");
	}

}
