package com.kata.marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kata.marsrover.enumeration.Direction;

public class CoordinatesTest {

	
	@Test
	void applyForward() {
		
		assertEquals(new Coordinates(new Point(0,1),Direction.NORTH), new Coordinates(new Point(0,0),Direction.NORTH).forward());
	}
	
}
