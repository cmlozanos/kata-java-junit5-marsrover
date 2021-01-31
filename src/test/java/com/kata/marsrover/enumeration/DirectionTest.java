package com.kata.marsrover.enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

	@ParameterizedTest(name = "direction from {0} to next will be expected {1}")
	@CsvSource({
			"NORTH, EAST",
			"EAST, SOUTH",
			"SOUTH, WEST",
			"WEST, NORTH",
	})
	void nextDirection(Direction origin, Direction destination) {
		assertEquals(destination.name(), origin.next().name());
	}

	@ParameterizedTest(name = "direction from {0} to next will be expected {1}")
	@CsvSource({
		"NORTH, WEST",
		"WEST, SOUTH",
		"SOUTH, EAST",
		"EAST, NORTH",
	})
	void previousDirection(Direction origin, Direction destination) {
		assertEquals(destination.name(), origin.previous().name());
	}
}
