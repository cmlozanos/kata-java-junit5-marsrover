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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}
}
