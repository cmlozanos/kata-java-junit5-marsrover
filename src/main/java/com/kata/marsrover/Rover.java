package com.kata.marsrover;

public class Rover {

	private final Navigator navigator;

	public Rover(int x, int y, String direction) {
		this.navigator = new Navigator(x, y, direction, null);
	}

	public String report() {
		return navigator.report();
	}

	public void navigate(String command) {
		navigator.navigate(command);
	}
}