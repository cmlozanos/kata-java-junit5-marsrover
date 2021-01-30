/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarsRoverTest {
	
	@ParameterizedTest(name = "x: {0}, y:{1}, direction:{2}")
	@CsvSource({
			"4, 2, NORTH",
			"0, 0, EAST"
	})
	void testRoverCreation(int x, int y, String direction) {
		var rover = new Rover(x, y, direction);
		assertEquals("Rover", rover.getClass().getSimpleName());
		assertEquals(String.format("(%d, %d) %s", x, y, direction), rover.report());
	}

	@Test
	void testRoverInvalidCreation() {
		assertThrows(IllegalArgumentException.class,() -> new Rover(0,0,"SOUTHWEST"));
	}
	
	@ParameterizedTest(name = "navigation from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({
			"4, 2, EAST, F, 5, 2, EAST",
			"1, 2, EAST, B , 0, 2, EAST",
			"4, 2, WEST, F, 3, 2, WEST",
			"1, 2, WEST, B , 2, 2, WEST",
			"4, 2, NORTH, F, 4, 3, NORTH",
			"1, 2, NORTH, B , 1, 1, NORTH",
			"4, 2, SOUTH, F, 4, 1, SOUTH",
			"1, 2, SOUTH, B , 1, 3, SOUTH"
	})
	void testRoverNavigation(int x, int y, String direction, String command, int xExpected, int yExpected,
			String directionExpected) {
		Rover rover = new Rover(x, y, direction);
		rover.navigate(command);
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), rover.report());
	}
	
	@Test
	void testRoverNavigationForInvalidCommand() {
		assertThrows(IllegalArgumentException.class, ()-> new Rover(0,0,"SOUTH").navigate("P"));
	}
	
	@ParameterizedTest(name = "navigation from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({
			"0, 0, NORTH, R, 0, 0, EAST",
			"0, 0, EAST, R, 0, 0, SOUTH",
			"0, 0, SOUTH, R, 0, 0, WEST",
			"0, 0, WEST, R, 0, 0, NORTH",
			"0, 0, NORTH, L, 0, 0, WEST",
			"0, 0, WEST, L, 0, 0, SOUTH",
			"0, 0, SOUTH, L, 0, 0, EAST",
			"0, 0, EAST, L, 0, 0, NORTH",
	})
	void testRoverNavigationForRotationCommand(int x, int y, String direction, String command, int xExpected, int yExpected,
			String directionExpected) {
		Rover rover = new Rover(x, y, direction);
		rover.navigate(command);
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), rover.report());
	}
	
	@ParameterizedTest(name = "navigation from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({
			"0, 0, NORTH, FRFRFR, 1, 0, WEST",
			"0, 0, NORTH, FRLRFR, 1, 1, SOUTH",
			"4, 2, EAST, FLFFFRFLB, 6, 4, NORTH"
	})
	void testRoverNavigationForMultipleCommands(int x, int y, String direction, String commands, int xExpected, int yExpected,
			String directionExpected) {
		Rover rover = new Rover(x, y, direction);
		rover.navigate(commands);
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), rover.report());
	}
	
}
