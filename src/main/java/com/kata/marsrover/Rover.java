package com.kata.marsrover;

public class Rover {

	private int x;
	private int y;
	private String direction;

	public Rover(int x, int y, String direction) {
		this.setX(x);
		this.setY(y);
		validateDirection(direction);
	}

	private void validateDirection(String direction) {
		if ("NORTH".equals(direction) || "EAST".equals(direction) || "SOUTH".equals(direction) || "WEST".equals(direction)) {
			this.direction = direction;
		}else {
			throw new IllegalArgumentException();
		}
	}

	public String report() {
		return String.format("(%d, %d) %s", getX(), getY(), getDirection());
	}

	public String getDirection() {
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
}