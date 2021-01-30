package com.kata.marsrover;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

public class Navigator {

	private final Coordinates coordinates;

	public Navigator(int x, int y, String direction) {
		this.coordinates = new Coordinates(new Point(x, y), Direction.valueOf(direction));
	}

	public Rover navigate(String commands) {
		Coordinates coordinates = this.coordinates;
		for (String command : commands.split("")) {
			coordinates = translate(command, coordinates);
		}
		return new Rover(coordinates.getPoint().getX(), coordinates.getPoint().getY(),
				coordinates.getDirection().name());
	}

	private Coordinates translate(String command, Coordinates coordinates) {

		Point point = coordinates.getPoint();
		Direction direction = coordinates.getDirection();

		switch (Command.valueOf(command)) {
		case B: {
			point = applyCommandBackward(coordinates);
			break;
		}
		case F: {
			point = coordinates.forward();
			break;
		}
		case R: {
			direction = coordinates.getDirection().next();
			break;
		}
		case L: {
			direction = coordinates.getDirection().previous();
			break;
		}
		}

		return new Coordinates(point, direction);
	}

	private Point applyCommandBackward(Coordinates coordinates) {
		switch (coordinates.getDirection()) {
		case WEST: {
			return coordinates.getPoint().addStepOnX();
		}
		case NORTH: {
			return coordinates.getPoint().subtractStepOnY();
		}
		case SOUTH: {
			return coordinates.getPoint().addStepOnY();
		}
		case EAST: {
			return coordinates.getPoint().subtractStepOnX();
		}
		}
		return coordinates.getPoint();
	}

	public String report() {
		return String.format("%s %s", this.coordinates.getPoint(), this.coordinates.getDirection());
	}

}