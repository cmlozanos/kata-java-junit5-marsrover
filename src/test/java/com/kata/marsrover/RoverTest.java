package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

class RoverTest {

	@ParameterizedTest(name = "x: {0}, y:{1}, direction:{2}")
	@CsvSource({ "4, 2, NORTH", "0, 0, EAST" })
	void testRoverCreation(int x, int y, String direction) {
		var rover = new Rover(x, y, direction, null);
		assertEquals("Rover", rover.getClass().getSimpleName());
		assertEquals(String.format("(%d, %d) %s", x, y, direction), rover.report());
		assertEquals(Set.of(), rover.getObstacles());
	}

	@Test
	void testRoverInvalidCreation() {
		assertThrows(IllegalArgumentException.class, () -> new Rover(0, 0, "SOUTHWEST", null));
	}

	@ParameterizedTest(name = "navigate from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({ "4, 2, EAST, F, 5, 2, EAST", "1, 2, EAST, B , 0, 2, EAST", "4, 2, WEST, F, 3, 2, WEST",
			"1, 2, WEST, B , 2, 2, WEST", "4, 2, NORTH, F, 4, 3, NORTH", "1, 2, NORTH, B , 1, 1, NORTH",
			"4, 2, SOUTH, F, 4, 1, SOUTH", "1, 2, SOUTH, B , 1, 3, SOUTH" })
	void testRoverNavigation(int x, int y, String direction, String command, int xExpected, int yExpected,
			String directionExpected) {
		Rover rover = new Rover(x, y, direction, null);
		rover.navigate(command);
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), rover.report());
	}

	@Test
	void testRoverNavigationForInvalidCommand() {
		Rover rover = new Rover(0, 0, "SOUTH", null);
		assertThrows(IllegalArgumentException.class, () -> rover.navigate("P"));
	}

	@ParameterizedTest(name = "navigate from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({ "0, 0, NORTH, R, 0, 0, EAST", "0, 0, EAST, R, 0, 0, SOUTH", "0, 0, SOUTH, R, 0, 0, WEST",
			"0, 0, WEST, R, 0, 0, NORTH", "0, 0, NORTH, L, 0, 0, WEST", "0, 0, WEST, L, 0, 0, SOUTH",
			"0, 0, SOUTH, L, 0, 0, EAST", "0, 0, EAST, L, 0, 0, NORTH", })
	void testRoverNavigationForRotationCommand(int x, int y, String direction, String command, int xExpected,
			int yExpected, String directionExpected) {
		Rover rover = new Rover(x, y, direction, null);
		rover.navigate(command);
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), rover.report());
	}

	@ParameterizedTest(name = "rover from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({ "0, 0, NORTH, FRFRFR, 1, 0, WEST", "0, 0, NORTH, FRLRFR, 1, 1, SOUTH",
			"4, 2, EAST, FLFFFRFLB, 6, 4, NORTH" })
	void testRoverRoverForMultipleCommands(int x, int y, String direction, String commands, int xExpected,
			int yExpected, String directionExpected) {
		Rover rover = new Rover(x, y, direction, null);
		rover.navigate(commands);
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), rover.report());
	}

	@ParameterizedTest
	@CsvSource({ "4, 3, EAST, F, 5, 3", "0, 0, EAST, F, 1, 0", "3, 2, EAST, B, 2, 2", "2, 2, EAST, B, 1, 2",
			"0, 0, NORTH, F, 0 , 1" })
	void testRoverNavigationWithObstacles(int x, int y, String direction, String command, int xFoundObstacle,
			int yFoundObstacle) {

		Set<Point> obstacles = Set.of(new Point(5, 3), new Point(1, 0), new Point(2, 2), new Point(1, 2),
				new Point(0, 1), new Point(3, 0));

		Rover rover = new Rover(x, y, direction, obstacles);

		rover.navigate(Command.valueOf(command).name());

		assertEquals(String.format("Obstacle at (%s,%s)", xFoundObstacle, yFoundObstacle), rover.getError());
		assertEquals(new Point(x, y), rover.getPoint());
	}

	@Test
	void testRoverNavigationWithObstaclesNoCollapsed() {
		Set<Point> obstacles = Set.of(new Point(5, 3), new Point(1, 0), new Point(2, 2), new Point(1, 2),
				new Point(0, 1), new Point(3, 0));
		Rover rover = new Rover(5, 5, Direction.SOUTH.name(), obstacles);

		rover.navigate(Command.F.name());

		assertEquals("", rover.getError());
		assertEquals(new Point(5, 4), rover.getPoint());
	}
}
