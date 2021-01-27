/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MarsRoverTest {

	public class RoverTranslator {
		public Rover translate(String command, Rover rover) {
			
			if (isCommandBackward(command) && isDirectionWest(rover.getDirection())) {
				rover.setY(rover.getY() + 1);
			}
			
			if (isCommandBackward(command) && isDirectionNorth(rover.getDirection())) {
				rover.setX(rover.getX() - 1);
			}
			
			if (isCommandBackward(command) && isDirectionSouth(rover.getDirection())) {
				rover.setX(rover.getX() + 1);
			} 
			
			if (isCommandBackward(command) && isDirectionEast(rover.getDirection())) {
				rover.setY(rover.getY() - 1);
			}
			
			if (isCommandForward(command) && isDirectionWest(rover.getDirection())) {
				rover.setY(rover.getY() - 1);
			}
			
			if (isCommandForward(command) && isDirectionNorth(rover.getDirection())) {
				rover.setX(rover.getX() + 1);
			}
			
			if (isCommandForward(command) && isDirectionSouth(rover.getDirection())) {
				rover.setX(rover.getX() - 1);
			} 
			
			if (isCommandForward(command) && isDirectionEast(rover.getDirection())) {
				rover.setY(rover.getY() + 1);
			}
			
			return new Rover(rover.getX(), rover.getY(), rover.getDirection());
		}


		private boolean isDirectionEast(String direction) {
			return "EAST".equals(direction);
		}

		private boolean isDirectionWest(String direction) {
			return "WEST".equals(direction);
		}

		private boolean isDirectionNorth(String direction) {
			return "NORTH".equals(direction);
		}

		private boolean isDirectionSouth(String direction) {
			return "SOUTH".equals(direction);
		}

		private boolean isCommandBackward(String command) {
			return "B".equals(command);
		}
		
		private boolean isCommandForward(String command) {
			return "F".equals(command);
		}
	}
	
	@ParameterizedTest(name = "x: {0}, y:{1}, direction:{2}")
	@CsvSource({
			"4, 2, EAST",
			"1, 2, EAST",
			"0, 0, EAST"
	})
	void testRoverCreation(int x, int y, String direction) {
		var rover = new Rover(x, y, direction);
		assertEquals("Rover", rover.getClass().getSimpleName());
		assertEquals(String.format("(%d, %d) %s", x, y, direction), rover.report());
	}

	@ParameterizedTest(name = "trnaslation from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({
			"4, 2, EAST, F, 4, 3, EAST",
			"1, 2, EAST, B , 1, 1, EAST",
			"4, 2, WEST, F, 4, 1, WEST",
			"1, 2, WEST, B , 1, 3, WEST",
			"4, 2, NORTH, F, 5, 2, NORTH",
			"1, 2, NORTH, B , 0, 2, NORTH",
			"4, 2, SOUTH, F, 3, 2, SOUTH",
			"1, 2, SOUTH, B , 2, 2, SOUTH"
	})
	void testRoverTranslation(int x, int y, String direction, String command, int xExpected, int yExpected,
			String directionExpected) {
		var rover = new Rover(x, y, direction);
		var roverTranslator = new RoverTranslator();

		var roverAfterTranslation = roverTranslator.translate(command, rover);

		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), roverAfterTranslation.report());
	}
}
