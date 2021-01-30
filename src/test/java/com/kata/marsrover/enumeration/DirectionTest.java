package com.kata.marsrover.enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectionTest {

	@Test
	void nextDirection() {
		assertEquals(Direction.EAST.name(), Direction.NORTH.next().name());
	}
}
