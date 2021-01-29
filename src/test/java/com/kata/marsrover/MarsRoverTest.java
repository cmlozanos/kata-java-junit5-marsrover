/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.kata.marsrover.Rover.Direction;

public class MarsRoverTest {

	public enum Command {
		F, B, R;
	}
	
	public class RoverTranslator {
		
		public Rover translate(String command, Rover rover) {

			switch (Command.valueOf(command)){
				case B: {
					applyCommandBackward(command, rover);
					break;
				}
				case F: {
					applyCommandForward(command, rover);
					break;
				}
				case R: {
					applyCommandRight(rover);
					break;
				}
			}

			return new Rover(rover.getX(), rover.getY(), rover.getDirection().name());
		}

		private void applyCommandRight(Rover rover) {
			switch (rover.getDirection()){
				case NORTH: {
					rover.setDirection(Direction.EAST);
					break;
				}
				case EAST: {
					rover.setDirection(Direction.SOUTH);
					break;
				}
				case SOUTH:{
					rover.setDirection(Direction.WEST);
					break;
				}
				case WEST:{
					rover.setDirection(Direction.NORTH);
					break;
				}
			}
		}

		private void applyCommandForward(String command, Rover rover) {
			switch (rover.getDirection()) { 
				case WEST: {
					rover.setX(rover.getX() - 1);
					break;
				}
				case NORTH: {
					rover.setY(rover.getY() + 1);
					break;
				}
				case SOUTH: {
					rover.setY(rover.getY() - 1);
					break;
				}
				case EAST: {
					rover.setX(rover.getX() + 1);
					break;
				}
			}
		}

		private void applyCommandBackward(String command, Rover rover) {
			switch (rover.getDirection()) {
				case WEST: {
					rover.setX(rover.getX() + 1);
					break;
				}
				case NORTH: {
					rover.setY(rover.getY() - 1);
					break;
				}
				case SOUTH: {
					rover.setY(rover.getY() + 1);
					break;
				}
				case EAST: {
					rover.setX(rover.getX() - 1);
					break;
				}
			}
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

	@Test
	void testRoverInvalidCreation() {
		assertThrows(IllegalArgumentException.class,() -> new Rover(0,0,"SOUTHWEST"));
	}
	
	@ParameterizedTest(name = "translation from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
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
	void testRoverTranslation(int x, int y, String direction, String command, int xExpected, int yExpected,
			String directionExpected) {
		var rover = new Rover(x, y, direction);
		var roverTranslator = new RoverTranslator();

		var roverAfterTranslation = roverTranslator.translate(command, rover);

		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), roverAfterTranslation.report());
	}
	
	@Test
	void testRoverTranslationForInvalidCommand() {
		assertThrows(IllegalArgumentException.class, ()-> new RoverTranslator().translate("P", new Rover(0,0,"SOUTH")));
	}
	
	@ParameterizedTest(name = "translation from ({0},{1} {2}) with command {3} expected ({4},{5} {6})")
	@CsvSource({
			"0, 0, NORTH, R, 0, 0, EAST",
			"0, 0, EAST, R, 0, 0, SOUTH",
			"0, 0, SOUTH, R, 0, 0, WEST",
			"0, 0, WEST, R, 0, 0, NORTH",
	})
	void testRoverTranslationForRotationCommand(int x, int y, String direction, String command, int xExpected, int yExpected,
			String directionExpected) {
		var roverAfterTranslation = new RoverTranslator().translate(command, new Rover(x, y, direction));
		assertEquals(String.format("(%d, %d) %s", xExpected, yExpected, directionExpected), roverAfterTranslation.report());
	}
}
