package com.tektree.simple.thread;

import com.tektree.simple.bean.Value;

public class MyThread1 extends Thread {
	
	private Value value;

	public MyThread1(Value value) {
		this.value = value;
	}

	@Override
	public void run() {
		// do something
		for (int i = 1; i <= 100; i++) {
			Integer val = value.getVal();
			value.setVal(new Integer(val + 1));
		}
	}

}
