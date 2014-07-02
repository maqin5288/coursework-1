package com.tektree.simple.vehicle;

public final class Sedan extends Car {

	@Override
	public String engineType() {
		System.out.println(super.driveType());
		return "V6";
	}
	
}
