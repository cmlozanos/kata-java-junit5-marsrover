package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

class NavigatorTest {

	@Test
	void testNavigatorCreation() {
		int x = 0;
		int y = 0;
		String direction = "NORTH";

		var navigator = new Navigator(x, y, direction, null);

		assertEquals("Navigator", navigator.getClass().getSimpleName());
		assertEquals(String.format("(%d, %d) %s", x, y, direction), navigator.report());
	}

	@ParameterizedTest
	@CsvSource({ "4, 3, EAST, F, 5, 3", "0, 0, EAST, F, 1, 0", "3, 2, EAST, B, 2, 2", "2, 2, EAST, B, 1, 2",
			"0, 0, NORTH, F, 0 , 1" })
	void obstacle(int x, int y, String direction, String command, int xFoundObstacle, int yFoundObstacle) {

		Set<Point> obstacles = Set.of(new Point(5, 3), new Point(1, 0), new Point(2, 2), new Point(1, 2),
				new Point(0, 1), new Point(3, 0));

		Navigator navigator = new Navigator(x, y, direction, obstacles);

		navigator.navigate(Command.valueOf(command).name());

		assertEquals(String.format("Obstacle at (%s,%s)", xFoundObstacle, yFoundObstacle), navigator.getError());
		assertEquals(new Point(x, y), navigator.getPoint());
	}

	@Test
	void noCollated() {
		Set<Point> obstacles = Set.of(new Point(5, 3), new Point(1, 0), new Point(2, 2), new Point(1, 2),
				new Point(0, 1), new Point(3, 0));
		Navigator navigator = new Navigator(5, 5, Direction.SOUTH.name(), obstacles);

		navigator.navigate(Command.F.name());

		assertEquals("", navigator.getError());
		assertEquals(new Point(5, 4), navigator.getPoint());
	}
}
