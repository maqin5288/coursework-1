package com.tektree.math;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ArithmeticTest {

	@Test(expected = IllegalArgumentException.class)
	public void addFirstArgumentNull() {
		Arithmetic.add(null, 20);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addSecondArgumentNull() {
		Arithmetic.add(20, null);
	}

	@Test
	public void add() {
		Integer actual = Arithmetic.add(10, 20);
		assertThat(actual, is(30));
	}

	// TODO: Add more tests
}
