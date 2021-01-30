package com.kata.marsrover.enumeration;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	public Direction next() {
		if(isLastElement()) {
			return Direction.values()[0];
		}
		return Direction.values()[this.ordinal() + 1];
	}

	public Direction previous() {
		if(isFirstElement()) {
			return Direction.values()[Direction.values().length - 1];
		}
		return Direction.values()[this.ordinal() - 1];
	}

	private boolean isFirstElement() {
		return this.ordinal() == 0;
	}

	private boolean isLastElement() {
		return this.ordinal() == Direction.values().length - 1;
	}

}
