package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NavigatorTest {

	@Test
	void testNavigatorCreation() {
		int x = 0;
		int y = 0;
		String direction = "NORTH";
		
		var navigator = new Navigator(x, y, direction);
		
		assertEquals("Navigator", navigator.getClass().getSimpleName());
		assertEquals(String.format("(%d, %d) %s", x, y, direction), navigator.report());
	}
}
