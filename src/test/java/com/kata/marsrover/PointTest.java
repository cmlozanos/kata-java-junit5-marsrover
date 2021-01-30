package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointTest {
	
	@Test
	void testNavigatorCreation() {
		int x = 0;
		int y = 0;
		
		var point = new Point(x, y);
		
		assertEquals("Point", point.getClass().getSimpleName());
		assertEquals(String.format("(%d, %d)", x, y), point.toString());
	}

}
