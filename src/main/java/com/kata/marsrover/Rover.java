package com.kata.marsrover;

public class Rover {

	private final Navigator navigator;
	
	public Rover(int x, int y, String direction) {
		this.navigator = new Navigator(x, y, direction);
	}

	public String report() {
		return navigator.report();
	}

	public Rover navigate(String command) {
		return navigator.navigate(command);
	}
}