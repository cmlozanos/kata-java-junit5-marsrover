/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarsRoverTest {

	public class Rover {

		private int x;
		private int y;
		private String direction;

		public Rover(int x, int y, String direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public String report() {
			return String.format("(%d, %d) %s", x, y, direction);
		}
	}

	@ParameterizedTest(name = "x: {0}, y:{1}, direction:{2}")
	@CsvSource({
			"4, 2, EAST",
			"1, 2, EAST",
			"0, 0, EAST"
	})
	void testRoverCreation(int x, int y, String direction) {
    	var rover = new Rover(x,y,direction);
		assertEquals("Rover", rover.getClass().getSimpleName());
    	assertEquals(String.format("(%d, %d) %s", x, y, direction), rover.report());
    }
}
