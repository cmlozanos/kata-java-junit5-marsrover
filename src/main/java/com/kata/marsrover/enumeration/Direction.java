package com.kata.marsrover.enumeration;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	Direction next() {
		return Direction.EAST;
	}
}
