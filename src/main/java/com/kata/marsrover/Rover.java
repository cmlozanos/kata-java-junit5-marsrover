package com.kata.marsrover;

import com.kata.marsrover.enumeration.Direction;

public class Rover {

	private final Point point;
	private final Direction direction;

	public Rover(int x, int y, String direction) {
		this.point = new Point(x, y);
		this.direction = Direction.valueOf(direction);
	}

	public Rover(Point point, Direction direction) {
		this.point = point;
		this.direction = direction;
	}

	public String report() {
		return String.format("%s %s", getPoint(), getDirection());
	}

	public Direction getDirection() {
		return direction;
	}

	public int getY() {
		return this.point.getY();
	}

	public int getX() {
		return this.point.getX();
	}

	public Point getPoint() {
		return this.point;
	}
}