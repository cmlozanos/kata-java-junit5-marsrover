package com.kata.marsrover;

import java.util.Optional;
import java.util.Set;

import com.kata.marsrover.enumeration.Command;
import com.kata.marsrover.enumeration.Direction;

public class Navigator {

	private Coordinates coordinates;
	private Set<Point> obstacles;
	private String error;

	public Navigator(int x, int y, String direction, Set<Point> obstacles) {
		this.coordinates = new Coordinates(new Point(x, y), Direction.valueOf(direction));
		this.obstacles = obstacles;
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
		this.error = "";

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

		point = findObstaclesAndReturnPoint(command, coordinates, point);

		return new Coordinates(point, direction);
	}

	private Point findObstaclesAndReturnPoint(String command, Coordinates coordinates, Point point) {
		if ((command.equals(Command.F.name()) || command.equals(Command.B.name()))) {
			Optional<Point> found = obstacles.stream().filter(point::equals).findFirst();
			if (found.isPresent()) {
				this.error = String.format("Obstacle at (%s,%s)", found.get().x, found.get().y);
				return coordinates.getPoint();
			}
		}
		return point;
	}

	public String report() {
		return String.format("%s %s", this.coordinates.getPoint(), this.coordinates.getDirection());
	}

	public Point getPoint() {
		return this.coordinates.getPoint();
	}

	public String getError() {
		return this.error;
	}

}