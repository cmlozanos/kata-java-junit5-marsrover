package com.kata.marsrover;

import com.kata.marsrover.enumeration.Direction;

public class Rover {

	private int x;
	private int y;
	private Direction direction;

	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = Direction.valueOf(direction);
	}

	public String report() {
		return String.format("(%d, %d) %s", getX(), getY(), getDirection());
	}

	public Direction getDirection() {
		return direction;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Object getPoint() {
		return null;
	}
}