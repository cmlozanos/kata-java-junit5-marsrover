package com.kata.marsrover;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

public class Navigator {

	private Coordinates coordinates;

	public Navigator(int x, int y, String direction) {
		this.coordinates = new Coordinates(new Point(x, y), Direction.valueOf(direction));
	}

	public void navigate(String commands) {
		Coordinates coordinatesRepositioned = this.coordinates;
		for (String command : commands.split("")) {
			coordinatesRepositioned = navigate(command, coordinatesRepositioned);
		}

		this.coordinates = coordinatesRepositioned;
	}

	private Coordinates navigate(String command, Coordinates coordinates) {

		Point point = coordinates.getPoint();
		Direction direction = coordinates.getDirection();

		switch (Command.valueOf(command)) {
		case B: {
			point = coordinates.backward();
			break;
		}
		case F: {
			point = coordinates.forward();
			break;
		}
		case R: {
			direction = coordinates.right();
			break;
		}
		case L: {
			direction = coordinates.left();
			break;
		}
		}

		return new Coordinates(point, direction);
	}

	public String report() {
		return String.format("%s %s", this.coordinates.getPoint(), this.coordinates.getDirection());
	}

}