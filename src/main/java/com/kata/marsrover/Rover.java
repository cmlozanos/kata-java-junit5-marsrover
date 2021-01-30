package com.kata.marsrover;

import com.kata.marsrover.enumeration.Direction;

public class Rover {

	private Point point;
	private Direction direction;

	public Rover(int x, int y, String direction) {
		this.point = new Point(x, y);
		this.direction = Direction.valueOf(direction);
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

	public void setY(int y) {
		this.point.setY(y);
	}

	public int getX() {
		return this.point.getX();
	}

	public void setX(int x) {
		this.point.setX(x);
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Point getPoint() {
		return this.point;
	}
}