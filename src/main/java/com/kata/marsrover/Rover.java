package com.kata.marsrover;

import com.kata.marsrover.enumeration.Direction;

public class Rover {

	private final Navigator navigator;
	
	public Rover(int x, int y, String direction) {
		this.navigator = new Navigator(x, y, direction);
	}

	public String report() {
		return navigator.report();
	}

	public Direction getDirection() {
		return this.navigator.getDirection();
	}

	public int getY() {
		return this.navigator.getY();
	}

	public int getX() {
		return this.navigator.getX();
	}

	public Point getPoint() {
		return this.navigator.getPoint();
	}

	public Rover navigate(String command) {
		return navigator.navigate(command);
	}
}