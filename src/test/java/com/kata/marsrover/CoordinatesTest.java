package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.kata.marsrover.enumeration.Direction;

public class CoordinatesTest {

	
	@ParameterizedTest(name = "forward from ({0},{1} {2}) expected ({3},{4})")
	@CsvSource({
			"0, 0, EAST, 1, 0",
			"0, 0, WEST, -1, 0",
			"0, 0, NORTH, 0, 1",
			"0, 0, SOUTH, 0, -1",
	})
	void applyForward(int x, int y, Direction direction, int xExpected, int yExpected) {
		assertEquals(new Point(xExpected,yExpected), new Coordinates(new Point(x,y),direction).forward());
	}

	@ParameterizedTest(name = "backward from ({0},{1} {2}) expected ({3},{4})")
	@CsvSource({
		"0, 0, EAST, -1, 0",
		"0, 0, WEST, 1, 0",
		"0, 0, NORTH, 0, -1",
		"0, 0, SOUTH, 0, 1",
	})
	void applyBackward(int x, int y, Direction direction, int xExpected, int yExpected) {
		assertEquals(new Point(xExpected,yExpected), new Coordinates(new Point(x,y),direction).backward());
	}
	
}
