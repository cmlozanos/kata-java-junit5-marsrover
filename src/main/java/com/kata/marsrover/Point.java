package com.kata.marsrover;

public class Point {

	private static final int STEPS_BY_COMMAND_OPERATION = 1;
	public final int x;
	public final int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}
	
	public Point addStepOnX() {
		return new Point(x + STEPS_BY_COMMAND_OPERATION, y);
	}

	public Point subtractStepOnX() {
		return new Point(x - STEPS_BY_COMMAND_OPERATION, y);
	}

	public Point addStepOnY() {
		return new Point(x, y + STEPS_BY_COMMAND_OPERATION);
	}
	
	public Point subtractStepOnY() {
		return new Point(x, y - STEPS_BY_COMMAND_OPERATION);
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}
}
