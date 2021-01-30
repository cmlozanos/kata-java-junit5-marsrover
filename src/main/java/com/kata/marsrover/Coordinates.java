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

	public Point forward() {
		switch (this.direction) {
		case WEST: {
			return this.point.subtractStepOnX();
		}
		case NORTH: {
			return this.point.addStepOnY();
		}
		case SOUTH: {
			return this.point.subtractStepOnY();
		}
		case EAST: {
			return this.point.addStepOnX();
		}
		}
		return this.point;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (direction != other.direction)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinates [point=" + point + ", direction=" + direction + "]";
	}
	
}