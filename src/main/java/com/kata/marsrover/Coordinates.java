package com.kata.marsrover;

import com.kata.marsrover.enumeration.Direction;

public class Coordinates {
	private final Point point;
	private final Direction direction;

	public Coordinates(Point point, Direction direction) {
		this.point = point;
		this.direction = direction;
	}

	public Point getPoint() {
		return this.point;
	}

	public Direction getDirection() {
		return direction;
	}

	public Coordinates forward() {
		return null;
	}
}