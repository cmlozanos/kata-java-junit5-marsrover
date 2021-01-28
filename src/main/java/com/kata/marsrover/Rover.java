package com.kata.marsrover;

public class Rover {

	public enum Direction {
		NORTH, EAST, SOUTH, WEST
	}

	private int x;
	private int y;
	private Direction direction;

	public Rover(int x, int y, String direction) {
		this.setX(x);
		this.setY(y);
		this.direction = Direction.valueOf(direction);
	}

	public String report() {
		return String.format("(%d, %d) %s", getX(), getY(), getDirection());
	}

	public String getDirection() {
		return direction.name();
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
}