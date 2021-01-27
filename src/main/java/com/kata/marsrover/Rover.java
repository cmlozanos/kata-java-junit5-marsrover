package com.kata.marsrover;

public class Rover {

	private int x;
	private int y;
	private String direction;

	public Rover(int x, int y, String direction) {
		this.setX(x);
		this.setY(y);
		this.direction = direction;
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