package com.tektree.simple.thread;

import com.tektree.simple.bean.Value;

public class MyThread2 implements Runnable {
	
	private Value value;

	public MyThread2(Value value) {
		this.value = value;
	}

	public void run() {
		// do something
		for (int i = 1; i <= 100; i++) {
			Integer val = value.getVal();
			value.setVal(new Integer(val - 1));
		}
	}

}
