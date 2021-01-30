package com.kata.marsrover.enumeration;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	Direction next() {
		if(isLastElement()) {
			return Direction.values()[0];
		}
		return Direction.values()[this.ordinal() + 1];
	}

	private boolean isLastElement() {
		return this.ordinal() == Direction.values().length - 1;
	}
}
