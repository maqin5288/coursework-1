package com.tektree.simple.bean;

import com.tektree.simple.annotation.Restriction;

public class Value {
	
	@Restriction(pattern = 1000)
	private Integer val = 0;


	@Restriction(pattern = 1100)
	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

}
